package ru.vyaacheslav.suhov.imeit.temp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.temp.SettingsPoly

class SettingsBellsAdapter(
        private val context: Context,
       private val list: List<SettingsPoly>

) : RecyclerView.Adapter<SettingsBellsAdapter.ViewHolder>() {

    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // наш пункт состоит только из одного TextView
        val name: TextView = itemView.findViewById(R.id.nameSett)
        val value: EditText = itemView.findViewById(R.id.editTextBells)
        val ch: CheckBox = itemView.findViewById(R.id.ch)
        val md: CheckBox = itemView.findViewById(R.id.md)
    }

    // Создает новые views (вызывается layout manager-ом)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): SettingsBellsAdapter.ViewHolder {
        // create a new view
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.bells_poly, parent, false)

        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)

        return ViewHolder(v)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

      /*  holder.name.text = list[position].name
        holder.value.setText(list[position].data.toString(), TextView.BufferType.EDITABLE)*/
    }

    // Возвращает размер данных (вызывается layout manager-ом)
    override fun getItemCount(): Int {
      /*  return list.size*/
        return 0
    }


    fun dontWritheUser(holder: ViewHolder, position: Int) {

        holder.value.isClickable = false
    }

}