package com.example.a2018213489_zty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class Adapter(val name:ArrayList<String>, val sentence:ArrayList<String>): RecyclerView.Adapter<Adapter.ViewHolder>(){//adapter
inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val name_text: TextView = view.findViewById(R.id.textname)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_adapter,parent,false)
        val viewHolder = ViewHolder(view)
        val button:TextView=view.findViewById(R.id.back1)
        button.setOnClickListener{
            val position = viewHolder.adapterPosition
            name.removeAt(position)
            sentence.removeAt(position)
            if (name.isEmpty())
            {
                val intent = Intent(parent.context,MainActivity::class.java)
                parent.context.startActivity(intent)
            }
            else {
                val intent = Intent(parent.context, com.example.a2018213489_zty.View::class.java)
                intent.putExtra("name", name)
                intent.putExtra("sentence", sentence)
                parent.context.startActivity(intent)
            }
        }
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val sentence = sentence[position]
            val intent = Intent(parent.context, MainActivity2::class.java)
            intent.putExtra("sentence1",sentence)
            parent.context.startActivity(intent)
        }
        return viewHolder
    }

    override fun getItemCount()=name.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val names = name[position]
        holder.name_text.text = names
    }
}
