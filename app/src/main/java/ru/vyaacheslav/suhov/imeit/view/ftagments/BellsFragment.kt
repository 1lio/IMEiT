package ru.vyaacheslav.suhov.imeit.view.ftagments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.util.BellListUtils
import ru.vyaacheslav.suhov.imeit.util.BellsGenerator
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.app.App
import ru.vyaacheslav.suhov.imeit.util.BellSettings
import ru.vyaacheslav.suhov.imeit.view.adapters.BellsListAdapter
import ru.vyaacheslav.suhov.imeit.repository.DB
import ru.vyaacheslav.suhov.imeit.util.Constants.EXCEPTIONS
import ru.vyaacheslav.suhov.imeit.viewmodel.CallTimeViewModel

class BellsFragment : Fragment() {

    private var settings: BellSettings = BellSettings()
    private val handler: Handler = Handler()

    private lateinit var viewModel: CallTimeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Грузим данные из БД
        settings = try {
            DB(App().appContext).dbBellsSettings()[0]  // берем данные из базы
        } catch (e: Exception) {
            Log.e(EXCEPTIONS, "Data obtained from default settings. Error: $e")
            BellSettings()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fr_time, container, false)

        viewModel = ViewModelProviders.of(activity!!)[CallTimeViewModel::class.java]

        val recycler: RecyclerView = v.findViewById(R.id.recyclerTime)
        recycler.layoutManager = LinearLayoutManager(context)  // Инициализируем LayoutManager для работы с recycler
        recycler.adapter = BellsListAdapter(context!!, BellsGenerator(settings).getBellsList(), BellListUtils(settings).getNumberCurrentPair().second)  // Подключаемся к нашему адаптеру
        recycler.itemAnimator = DefaultItemAnimator() // Делаем плавную анимацию прокуртки
        recycler.setHasFixedSize(true)
        recycler.addItemDecoration(DividerItemDecoration(recycler.context, LinearLayoutManager(context).orientation)) // Добавляем вертикальный разделитель

        // Запускаем отдельный поток при старте активити для определения остатка времени до события
        handler.removeCallbacks(timeUpdaterRunnable)
        handler.postDelayed(timeUpdaterRunnable, 100)  // Запустим с задержкой 100 миллисекунд
        return v
    }

    /** Переопределяем методы onPause и onResume и обрабатываем наш handler*/
    override fun onPause() {
        super.onPause()
        // Удаляем Runnable-объект для прекращения задачи
        handler.removeCallbacks(timeUpdaterRunnable)
    }

    override fun onResume() {
        super.onResume()
        // Возобнавляем Runnable-объект через 100 милисекунд
        handler.postDelayed(timeUpdaterRunnable, 100)
    }

    /** @see timeUpdaterRunnable запускаем поток каждые 3 секунды, сравнивающий текущее время со списками*/
    private val timeUpdaterRunnable = object : Runnable {

        override fun run() {
            // Обновляем значения во viewModel
            viewModel.setTime(BellListUtils(settings).getThisTime())
            viewModel.setTimeLeft(BellListUtils(settings).getResidueTime())
            viewModel.setPairStatus(
                    when (BellListUtils(settings).getNumberCurrentPair().first) {
                        BellListUtils.TimeEvent.LUNCH -> resources.getString(R.string.time_lunch)
                        BellListUtils.TimeEvent.BREAK -> resources.getString(R.string.time_before)
                        else -> resources.getString(R.string.time_residue)
                    })

            // повторяем чезе 3 сек
            handler.postDelayed(this, 3000)
        }
    }
}