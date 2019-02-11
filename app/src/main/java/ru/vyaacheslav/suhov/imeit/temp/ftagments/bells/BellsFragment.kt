package ru.vyaacheslav.suhov.imeit.temp.ftagments.bells

import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fr_time.*
import ru.vyaacheslav.suhov.imeit.presentation.presenters.BellListUtils
import ru.vyaacheslav.suhov.imeit.presentation.presenters.BellsGenerator
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.domain.entity.BellSettings
import ru.vyaacheslav.suhov.imeit.temp.adapters.BellsListAdapter
import ru.vyaacheslav.suhov.imeit.temp.data.DB

class BellsFragment : Fragment() {


    private val handler: Handler = Handler()            // создадим объект класса Handler
    private var status: String = ""                     // Текущий статус пара или перемена
    private var settings: BellSettings = BellSettings()

    private lateinit var textTimer: String      // Строка для Таймера

    /** @see onCreate Выполним работу не связанную с интерфейсом */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Обновляем данные таймера
        timerUpdater()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fr_time, container, false)

        // Присваивание занчений
        //textTime.text = textTimer   // Остаток времени до конца пары
        // pair_status.text = status // Вью для статуса: пара или перемена


        settings = try {
            DB(this.context!!).dbBellsSettings()[0] // беру данные из базы
        } catch (e: Exception) {
            BellSettings()    // В случае exception используем дефолтные настройки
        }

        // Получим лист в ячейками
        val data = BellsGenerator(settings).getBellsList()
        val numPair = BellListUtils(settings).getNumberCurrentPair().second // Получим номер пары
        val adapter = BellsListAdapter(context!!, data, numPair)

        // Инициализируем LayoutManager для работы с recycler
        time_list.layoutManager = LinearLayoutManager(context)
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

    /** @see timerUpdater функция обновляет остаток до конца */
    private fun timerUpdater() {

        // Отобразим остаток по времени
        textTimer = BellListUtils(settings).getResidueTime
        status = when (BellListUtils(settings).getNumberCurrentPair().first) {
            BellListUtils.TimeEvent.LUNCH -> resources.getString(R.string.time_lunch)
            BellListUtils.TimeEvent.BREAK -> resources.getString(R.string.time_this_less)
            else -> resources.getString(R.string.time_residue)
        }
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