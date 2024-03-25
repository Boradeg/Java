package com.example.nav_bar_module_java_tutorial.ProgramAndSyntaxFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nav_bar_module_java_tutorial.R

class ItemAdapter(private val mList: List<DataModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item_program, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model = mList[position]
        holder.mTextView.text = model.itemText

        // Set LinearLayoutManager with horizontal orientation
        val layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.nestedRecyclerView.layoutManager = layoutManager

        val adapter = NestedAdapter(model.nestedList)
        holder.nestedRecyclerView.setHasFixedSize(true)
        holder.nestedRecyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTextView: TextView = itemView.findViewById(R.id.itemTv)
        val nestedRecyclerView: RecyclerView = itemView.findViewById(R.id.child_rv)
    }
}
