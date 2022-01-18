package com.example.shimmerframelayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemberAdapter(private val list: ArrayList<MyMember> = arrayListOf()) : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_member, parent, false)
        return MemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


    inner class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(member: MyMember) {
            val number = itemView.findViewById<TextView>(R.id.txt_number)
            val name = itemView.findViewById<TextView>(R.id.txt_name)
            val intro = itemView.findViewById<TextView>(R.id.txt_intro)

            number.text = member.number
            name.text = member.name
            intro.text = member.intro
        }
    }
}