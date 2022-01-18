package com.example.shimmerframelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: ArrayList<MyMember> = arrayListOf()
        list.add(MyMember("1","陳小美","大家好大家好大家好大家好大家好大家好大家好大家好大家好大家好"))
        list.add(MyMember("2","王小雲","哈囉哈囉哈囉哈囉哈囉哈囉哈囉哈囉哈囉哈囉哈囉哈囉哈囉哈囉哈囉"))


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = MemberAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this)


        if (list.size == 0){

        }else{

        }
    }
}