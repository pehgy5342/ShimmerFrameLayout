package com.example.shimmerframelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import android.R.attr.data
import android.os.Handler
import android.util.Log


class MainActivity : AppCompatActivity() {
    lateinit var adapter: VegAdapter
    lateinit var layout_loading: ShimmerFrameLayout
    lateinit var recyclerView: RecyclerView
    lateinit var list: ArrayList<Veg>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = arrayListOf()
        adapter = VegAdapter()


        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        layout_loading = findViewById(R.id.layout_loading)


        this.runOnUiThread(Runnable {
            connect()
        })

        if (list.isNotEmpty()) {
            (layout_loading as ShimmerFrameLayout).stopShimmer()
            layout_loading.visibility = View.GONE
            adapter.list = data as ArrayList<Veg>
        } else {
            layout_loading.visibility = View.VISIBLE
            (layout_loading as ShimmerFrameLayout).startShimmer()
            recyclerView.visibility = View.GONE
            adapter.list.clear()
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()

    }

    private fun connect() {
        val api = VegAPI()
        val url = api.getAPI()
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("error", "連線失敗")
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                val data = Gson().fromJson(result, Array<Veg>::class.java).toList()
                list = data as ArrayList<Veg>
            }
        })

    }
}