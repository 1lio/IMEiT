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
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.activity.SettingsActivity
import ru.vyaacheslav.suhov.imeit.adapters.RecyclerAdapter
import ru.vyaacheslav.suhov.imeit.core.PreferencesBells
import ru.vyaacheslav.suhov.imeit.core.utils.BellsUtils
import ru.vyaacheslav.suhov.imeit.data.DB

class BellsFragment : Fragment() {

    private lateinit var residueTextView: TextView      // Вью для вывода остатка
    private lateinit var pairStatus: TextView           // Статус состояния
    lateinit var mAdapter: RecyclerView.Adapter<*>      // Адаптер для списка
    private lateinit var textTimer: String              // Строка для Таймера
    private val handler: Handler = Handler()            // создадим объект класса Handler
    private var status: String = ""                     // Текущий статус пара или перемена

    private val defPref = PreferencesBells()
    // Выполним работу не связанную с интерфейсом
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Обновляем данные таймера
        timerUpdater()

        //  Подготовим адаптер для списка
        val lessons = DB(this.context!!).dbTimes()

        // Используем дефолтные настройки

        val check = BellsUtils(defPref).convertToCountBells()

        mAdapter = RecyclerAdapter(context!!, check)

        setHasOptionsMenu(true)
    }

    /* Метод onCreate должен быть наименне нагуржен */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fr_time, container, false)
        // Инициализация компоненттов
        residueTextView = v.findViewById(R.id.textTime)        // Остаток времени до конца пары
        pairStatus = v.findViewById(R.id.pair_status)          // Вью для статуса: пара или перемена
        val mRecyclerView: RecyclerView = v.findViewById(R.id.time_list)      // Список таблица с временем пар
        // Присваивание занчений
        residueTextView.text = textTimer
        pairStatus.text = status


        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        mRecyclerView.layoutManager = mLayoutManager

        mRecyclerView.adapter = mAdapter
        // Делаем плавную анимацию прокуртки
        val itemAnimator = DefaultItemAnimator()
        mRecyclerView.itemAnimator = itemAnimator

        mRecyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(activity)
        val dividerItemDecoration = DividerItemDecoration(mRecyclerView.context, linearLayoutManager.orientation)

        mRecyclerView.addItemDecoration(dividerItemDecoration)
        // Запускаем отдельный поток при старте активити
        handler.removeCallbacks(timeUpdaterRunnable)
        handler.postDelayed(timeUpdaterRunnable, 100)    // Запустим с задержкой 100 миллисекунд

        return v
    }

    override fun onPause() {
        // Удаляем Runnable-объект для прекращения задачи
        handler.removeCallbacks(timeUpdaterRunnable)
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        // Возобнавляем Runnable-объект
        handler.postDelayed(timeUpdaterRunnable, 100)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        val fav: MenuItem = menu.add(Menu.NONE, 12, 0, resources.getString(R.string.statistic))
        fav.setIcon(R.drawable.ic_assessment)
        fav.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return when (item!!.itemId) {
            R.id.settings -> {
                val settingsIntent = Intent(activity, SettingsActivity::class.java)
                startActivity(settingsIntent)
                super.onOptionsItemSelected(item)
            }
            12 -> {
                // Отобразим статистику
                super.onOptionsItemSelected(item)
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun timerUpdater() {

        val nunPair = BellsUtils(defPref).getNumberCurrentPair()
        // Используем строковые ресурсы, чтобы в дальнейшем сделать локализацию
        status = if (nunPair == 9) resources.getString(R.string.time_lunch) else resources.getString(R.string.time_residue)

        // Проверяем попадает время в промежуток, затем подставляем значение
        // В начале хотел переберать всё в цикле, но получилась страшная конструкция с кучей проверок
        val result = BellsUtils(defPref).getResidueTimePair()
        // Форматируем значение и присваиваем строке
        val format: String = if ((result < 10)) "0$result" else result.toString()
        textTimer = if ((format.toInt() < 59)) "00:$format" else "01:${format.toInt() - 60}"
    }

    private val timeUpdaterRunnable = object : Runnable {
        override fun run() {
            // Вызовем обновление нашего таймера
            timerUpdater()
            // Обновляем щзначения
            residueTextView.text = textTimer
            pairStatus.text = status

            // повторяем через каждые 3 секунды
            handler.postDelayed(this, 3000)
        }
    }


}