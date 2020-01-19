package com.arioki.belajarandroidjetpackpro.render.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arioki.belajarandroidjetpackpro.R
import com.arioki.belajarandroidjetpackpro.data.ModuleEntity


class ModuleListAdapter(val listener: MyAdapterClickListener) :
    RecyclerView.Adapter<ModuleListAdapter.ViewHolder>() {
    private val modules: ArrayList<ModuleEntity> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModuleListAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.items_module_list_custom,
            parent,
            false
        )
    )

    fun setModules(listModules: List<ModuleEntity>) {
        modules.clear()
        modules.addAll(listModules)
    }

    override fun getItemCount(): Int = modules.size
    override fun onBindViewHolder(holder: ModuleListAdapter.ViewHolder, position: Int) {
        val module = modules[position]
        holder.textTitle.text = module.title
        holder.itemView.setOnClickListener {
            listener.onItemClicked(holder.adapterPosition, modules[holder.adapterPosition].moduleId)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.findViewById(R.id.text_module_title)
        val textLastSeen: TextView = itemView.findViewById(R.id.text_last_seen)
    }
}