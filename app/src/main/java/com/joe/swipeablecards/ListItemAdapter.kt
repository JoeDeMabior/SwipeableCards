package com.joe.swipeablecards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.ListItem>() {

    private val items = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItem {
        return ListItem(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ListItem, position: Int) {
        holder.bind(items[position])
    }

    fun removeTopItem() {
        items.remove(0)
        notifyDataSetChanged()
    }

    class ListItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(index: Int) {
            val itemText: TextView = itemView.findViewById(R.id.text)
            itemText.text = index.toString()
        }

    }

}
