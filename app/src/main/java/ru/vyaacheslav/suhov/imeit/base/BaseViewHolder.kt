package ru.vyaacheslav.suhov.imeit.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>( itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setOnClickListener(listener: View.OnClickListener) {
        itemView.setOnClickListener(listener)
    }

    abstract fun bind(item: T)

    fun bind(item: T, position: Int) {
        bind(item)
    }
}
