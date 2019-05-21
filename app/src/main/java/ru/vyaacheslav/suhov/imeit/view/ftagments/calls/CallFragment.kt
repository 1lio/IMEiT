package ru.vyaacheslav.suhov.imeit.view.ftagments.calls

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.util.UtilBell
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.EducationEvent.BREAK
import ru.vyaacheslav.suhov.imeit.util.EducationEvent.LUNCH
import ru.vyaacheslav.suhov.imeit.view.adapters.CallListFragmentAdapter
import ru.vyaacheslav.suhov.imeit.viewmodel.CallTimeViewModel

class CallFragment : Fragment() {

    private lateinit var viewModel: CallTimeViewModel
    private val handler: Handler = Handler()
    private var pref: CallPref = CallPref()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fr_time, container, false)
        val recycler: RecyclerView = v.findViewById(R.id.recyclerTime)

        viewModel = ViewModelProviders.of(activity!!)[CallTimeViewModel::class.java]
        pref = viewModel.getPref()
        val adapter = CallListFragmentAdapter()

        recycler.layoutManager = LinearLayoutManager(context)
        // Подключаемся к нашему адаптеру
        recycler.adapter = adapter
        // Наблюдаем за элементами списка
        viewModel.observeListCalls(this, Observer {
            adapter.addAllAndNotify(it)
        })

        // Делаем плавную анимацию прокуртки
        recycler.itemAnimator = DefaultItemAnimator()
        // Добавляем вертикальный разделитель
        recycler.addItemDecoration(DividerItemDecoration(recycler.context, LinearLayoutManager(context).orientation))
        // Устанавливаем фиксированный размер
        recycler.setHasFixedSize(true)

        // Запускаем отдельный поток при старте активити для определения остатка времени до события
        handler.removeCallbacks(timeUpdaterRunnable)
        handler.postDelayed(timeUpdaterRunnable, 100)  // Запустим с задержкой 100 миллисекунд
        return v
    }

    /** Переопределяем методы onPause и onResume и обрабатываем handler*/
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

    /** Поток который отправляет во вью модель новые данные
     *  @return Поток обновляющийся каждые 3 секунды, сравнивающий текущее время со списками*/
    private val timeUpdaterRunnable = object : Runnable {
        override fun run() {
            val utils = UtilBell(pref)
            // Обновляем значения во viewModel
            // Текущее форматированное время
            viewModel.setTime(utils.getThisTime())
            // Соклько осталось
            viewModel.setTimeLeft(utils.getResidueTime())
            // Текущий статус пары
            viewModel.setPairStatus(
                    when (utils.getNumberCurrentPair().first) {
                        LUNCH -> resources.getString(R.string.time_lunch)
                        BREAK -> resources.getString(R.string.time_before)
                        else -> resources.getString(R.string.time_residue)
                    })

            // повторяем чезе 3 сек
            handler.postDelayed(this, 3000)
        }
    }
}