package com.example.nav_bar_module_java_tutorial.ProgramAndSyntaxFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nav_bar_module_java_tutorial.R

class NestedAdapter(private val mList: List<Pair<String, String>>) : RecyclerView.Adapter<NestedAdapter.NestedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nested_item_program, parent, false)
        return NestedViewHolder(view)
    }

    override fun onBindViewHolder(holder: NestedViewHolder, position: Int) {
        holder.mTv.text = mList[position].second
        holder.layout_show_prog.setOnClickListener {
            Toast.makeText(holder.itemView.context,mList[position].second, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class NestedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTv: TextView = itemView.findViewById(R.id.program_tv)
        val layout_show_prog: RelativeLayout = itemView.findViewById(R.id.layout_show_prog)
    }
}
