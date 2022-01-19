package com.example.shimmerframelayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VegAdapter : RecyclerView.Adapter<VegAdapter.MemberViewHolder>() {

    var list: ArrayList<Veg> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_veg, parent, false)
        return MemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


    inner class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(veg: Veg) {
            val name = itemView.findViewById<TextView>(R.id.txt_cropName)
            val code = itemView.findViewById<TextView>(R.id.txt_cropCode)

            name.text = veg.id
            code.text = veg.title
        }
    }
}