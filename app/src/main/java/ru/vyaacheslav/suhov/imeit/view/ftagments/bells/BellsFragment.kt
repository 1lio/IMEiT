package ru.vyaacheslav.suhov.imeit.view.ftagments.bells

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.repository.BellListGenerator
import ru.vyaacheslav.suhov.imeit.repository.BellsGenerator
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.BellData
import ru.vyaacheslav.suhov.imeit.view.adapters.BellsListFragmentAdapter
import ru.vyaacheslav.suhov.imeit.viewmodel.BellsTimeViewModel

class BellsFragment : Fragment() {

    private var settings: BellData = BellData()
    private val handler: Handler = Handler()

    private lateinit var viewModel: BellsTimeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Грузим данные из БД
        settings = BellData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fr_time, container, false)
        viewModel = ViewModelProviders.of(activity!!)[BellsTimeViewModel::class.java]

        val recycler: RecyclerView = v.findViewById(R.id.recyclerTime)
        recycler.layoutManager = LinearLayoutManager(context)  // Инициализируем LayoutManager для работы с recycler
        recycler.adapter = BellsListFragmentAdapter(BellsGenerator(settings).getBellsList())  // Подключаемся к нашему адаптеру
        recycler.itemAnimator = DefaultItemAnimator() // Делаем плавную анимацию прокуртки
        recycler.addItemDecoration(DividerItemDecoration(recycler.context, LinearLayoutManager(context).orientation)) // Добавляем вертикальный разделитель
        recycler.setHasFixedSize(true)

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
            viewModel.setTime(BellListGenerator(settings).getThisTime())
            viewModel.setTimeLeft(BellListGenerator(settings).getResidueTime())
            viewModel.setPairStatus(
                    when (BellListGenerator(settings).getNumberCurrentPair().first) {
                        BellListGenerator.TimeEvent.LUNCH -> resources.getString(R.string.time_lunch)
                        BellListGenerator.TimeEvent.BREAK -> resources.getString(R.string.time_before)
                        else -> resources.getString(R.string.time_residue)
                    })

            // повторяем чезе 3 сек
            handler.postDelayed(this, 3000)
        }
    }
}