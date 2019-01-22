package ru.vyaacheslav.suhov.imeit.ftagments.bells

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import core.entity.BellSettings
import core.util.BellListUtils
import core.util.BellsGenerator
import kotlinx.android.synthetic.main.fr_time.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.activity.SettingsActivity
import ru.vyaacheslav.suhov.imeit.adapters.BellsListAdapter
import ru.vyaacheslav.suhov.imeit.data.DB

class BellsFragment : Fragment() {

    //TODO: ПЕРЕДЕЛАТЬ ПОД MVVM

    private lateinit var adapter: RecyclerView.Adapter<*>      // Адаптер для списка
    private lateinit var textTimer: String              // Строка для Таймера
    private val handler: Handler = Handler()            // создадим объект класса Handler
    private var status: String = ""                     // Текущий статус пара или перемена
    private var settings: BellSettings = BellSettings()

    /** @see onCreate Выполним работу не связанную с интерфейсом */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Обновляем данные таймера
        timerUpdater()

        //TODO: Создать запрос из настроек и получить позицию с последними изменениями из БД
        val settingsPosition = 0 // Пока 0

        //  Подготовим адаптер для списка
        settings = try {
            DB(this.context!!).dbBellsSettings()[settingsPosition] // беру данные из базы
        } catch (e: Exception) {
            BellSettings()    // В случае exception используем дефолтные настройки
        }

        // Получим лист в ячейками
        val data = BellsGenerator(settings).getBellsList()
        val numPair = BellListUtils(settings).getNumberCurrentPair().second // Получим номер пары
        adapter = BellsListAdapter(context!!, data, numPair)

        // Вызовем метод для создания меню
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fr_time, container, false)

        // Присваивание занчений
        textTime.text = textTimer   // Остаток времени до конца пары
        pair_status.text = status // Вью для статуса: пара или перемена

        // Инициализируем LayoutManager для работы с recycler
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        time_list.layoutManager = mLayoutManager

        // Подключаемся к нашему адаптеру
        time_list.adapter = adapter

        // Делаем плавную анимацию прокуртки
        time_list.itemAnimator = DefaultItemAnimator()

        // Подтверждаем что размер нашего recycler не измениться
        time_list.setHasFixedSize(true) // Вроде улучшает производительность

        // Добавляем вертикальный разделитель, так как напрямую в разметке его сделать нельзя
        time_list.addItemDecoration(DividerItemDecoration(time_list.context, LinearLayoutManager(activity).orientation))

        // Запускаем отдельный поток при старте активити для определения остатка времени до события
        handler.removeCallbacks(timeUpdaterRunnable)
        handler.postDelayed(timeUpdaterRunnable, 100)    // Запустим с задержкой 100 миллисекунд

        return v
    }

    /** Переопределяем методы onPause и onResume и обрабатываем наш handler*/
    override fun onPause() {
        // Удаляем Runnable-объект для прекращения задачи
        handler.removeCallbacks(timeUpdaterRunnable)
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        // Возобнавляем Runnable-объект через 100 милисекунд
        handler.postDelayed(timeUpdaterRunnable, 100)
    }

    /** Переопределяем метод и добовляем кнопку */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        // Добавим кнопку для отображения статистики
        val fav: MenuItem = menu.add(Menu.NONE, 2, 0, resources.getString(R.string.statistic))
        fav.setIcon(R.drawable.ic_assessment)
        fav.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
    }

    // TODO: Добавить обработчик кнопокк в меню
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return when (item!!.itemId) {
            R.id.settings -> {
                val settingsIntent = Intent(activity, SettingsActivity::class.java)
                startActivity(settingsIntent)
                super.onOptionsItemSelected(item)
            }
            2 -> {
                // Отобразим статистику
                super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /** @see timerUpdater функция обновляет остаток до конца */
    private fun timerUpdater() {
        val typePair = BellListUtils(settings).getNumberCurrentPair().first
        // Используем строковые ресурсы, чтобы в дальнейшем сделать локализацию
        status = when (typePair) {
            BellListUtils.TimeEvent.LUNCH -> resources.getString(R.string.time_lunch)
            BellListUtils.TimeEvent.BREAK -> resources.getString(R.string.time_this_less)
            else -> resources.getString(R.string.time_residue)
        }
        // Отобразим остаток по времени
        textTimer = BellListUtils(settings).getResidueTime
    }

    /** @see timeUpdaterRunnable запускаем поток каждые 3 секунды, сравнивающий текущее время со списками*/
    private val timeUpdaterRunnable = object : Runnable {
        override fun run() {
            timerUpdater()  // Вызовем функцию для обновление нашего таймера
            // Обновляем значения
            textTime.text = textTimer
            pair_status.text = status
            // запускаем поток через каждые 3 секунды
            handler.postDelayed(this, 3000)
        }
    }
}