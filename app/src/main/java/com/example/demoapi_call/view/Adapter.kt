package com.example.demoapi_call.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapi_call.databinding.DataItemBinding
import com.example.demoapicall_setup.main_screen.model.DemoResponseItem

class Adapter(private val context: Context) : RecyclerView.Adapter<Adapter.ListViewHolder>() {
    var list: ArrayList<DemoResponseItem> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {

        val binding = DataItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) {
        holder.binding.txtTitle.text = list[position].title
        holder.binding.txtDes.text = list[position].body
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list: ArrayList<DemoResponseItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ListViewHolder(val binding: DataItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}