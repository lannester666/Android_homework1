package com.example.a2018213489_zty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class MainActivity2 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val data=intent.getStringExtra("sentence1")
        val text:TextView=findViewById(R.id.text_2)
        text.text=data
        val button:Button=findViewById(R.id.back)
        button.setOnClickListener {
            finish()
        }
    }
}