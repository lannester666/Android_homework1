package com.example.a2018213489_zty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList
class View : AppCompatActivity() {
    private var name = ArrayList<String>()
    private var sentence = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        initView()
        val layoutManager = LinearLayoutManager(this)
        val recyclerView:RecyclerView = findViewById(R.id.id_view)
        recyclerView.layoutManager = layoutManager
        val adapter = Adapter(name, sentence)
        recyclerView.adapter = adapter
    }
    private fun initView(){
        name = intent.getStringArrayListExtra("name") as ArrayList<String>
        sentence = intent.getStringArrayListExtra("sentence") as ArrayList<String>
    }
}