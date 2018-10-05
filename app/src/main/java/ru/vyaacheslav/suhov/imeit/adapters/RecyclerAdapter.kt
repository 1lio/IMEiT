package ru.vyaacheslav.suhov.imeit.adapters

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R
import java.util.*

class RecyclerAdapter(
        private val context: Context,
        private val num: ArrayList<String>,
        private val top1: ArrayList<String>,
        private val bot1: ArrayList<String>,
        private val top2: ArrayList<String>,
        private val bot2: ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // наш пункт состоит только из одного TextView
        val num: TextView = itemView.findViewById(R.id.t_num)
        val less1top: TextView = itemView.findViewById(R.id.t_top)
        val less1bot: TextView = itemView.findViewById(R.id.t_o_top)
        val less2top: TextView = itemView.findViewById(R.id.t_bott)
        val less2bot: TextView = itemView.findViewById(R.id.t_o_bott)

    }

    // Создает новые views (вызывается layout manager-ом)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerAdapter.ViewHolder {
        // create a new view
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.it_time, parent, false)

        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)

        return ViewHolder(v)
    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.num.text = num[position]
        holder.less1top.text = top1[position]
        holder.less1bot.text = bot1[position]
        holder.less2top.text = top2[position]
        holder.less2bot.text = bot2[position]

        val numTime = getPair()
        val color = ContextCompat.getColor(context, R.color.colorTransparent)
        if (numTime == position) {
            holder.itemView.setBackgroundColor(color)
        }
    }

    // Возвращает размер данных (вызывается layout manager-ом)
    override fun getItemCount(): Int {
        return num.size
    }

    private fun getPair(): Int {

        // Коллекции массивов времени продолжительности пар и интервалов между ними
        // Время пар в минутах с отчетом от первой пары
        val intervals: Array<IntRange> = arrayOf((510..605), (615..710), (711..749), (750..845),
                (855..950), (960..1055), (1065..1160)) // Диапозоны времени пар

        val calendar: Calendar = GregorianCalendar.getInstance()
        val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val min: Int = calendar.get(Calendar.MINUTE)

        val x = hour * 60 + min         // Получаем текущее время и переводим в минуты

        // Проверяем попадает время в промежуток, затем подставляем значение
        // В начале хотел переберать всё в цикле, но получилась страшная конструкция с кучей проверок

        return when (x) {

            in intervals[0] -> 0
            in intervals[1] -> 1
            in intervals[2] -> 2     // Большая перемена
            in intervals[3] -> 2
            in intervals[4] -> 3
            in intervals[5] -> 4
            in intervals[6] -> 5
            else -> 0
        }
    }
}