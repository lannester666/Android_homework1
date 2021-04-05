package com.example.a2018213489_zty

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.ArrayList
class MainActivity : AppCompatActivity() ,View.OnClickListener{
    val sentence = ArrayList<String>()
    val names = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1:Button=findViewById(R.id.show_info)
        val button2:Button=findViewById(R.id.delete_info)
        val button3:Button=findViewById(R.id.save)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
    }
    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?){
        val nid:EditText=findViewById(R.id.name)
        val aid:EditText=findViewById(R.id.age)
        val hid:EditText=findViewById(R.id.height)
        val text:TextView=findViewById(R.id.show_text)
        val name=nid.text.toString()
        val age = aid.text
        val height = hid.text
        val data = name + age.toString() + "岁了,身高是" + height.toString() + "米."
        when(v?.id){
            R.id.show_info->{
//                    text.text = data
                    val intent = Intent(this, com.example.a2018213489_zty.View::class.java)
                    intent.putExtra("name", names)
                    intent.putExtra("sentence",sentence)
//                    val intent = Intent(this, MainActivity2::class.java)
//                    intent.putExtra("sentence1",data)
                    startActivity(intent)
            }
            R.id.delete_info->{
                nid.setText("")
                aid.setText("")
                hid.setText("")
            }
            R.id.save->{

                text.text = data
                if (name.isEmpty())
                {
                    AlertDialog.Builder(this).apply {
                        setTitle("输入错误")
                        setMessage("请填写您的姓名！")
                        setCancelable(false)
                        setPositiveButton("我知道错了"){dialog, which ->
                        }
                        show()
                    }
                }
                else if (age.toString().toFloat()>150||height.toString().toFloat()>3)
                {
                    AlertDialog.Builder(this).apply {
                        setTitle("瞎填")
                        setMessage("宁这数据是人吗？")
                        setCancelable(false)
                        setPositiveButton("重填"){dialog, which ->
                            run {
                                nid.setText("")
                                aid.setText("")
                                hid.setText("")
                            }
                        }
                        show()
                    }
                }
                else {
                    sentence.add(data)
                    names.add(name)
//                    for(i in sentence)
//                        println(i)
//                    for(i in names)
//                        println(i)
                    nid.setText("")
                    aid.setText("")
                    hid.setText("")
                }
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.setting -> Toast.makeText(this,"You clicked Setting!",Toast.LENGTH_SHORT).show()
            R.id.create -> Toast.makeText(this,"You clicked Create",Toast.LENGTH_SHORT).show()
            R.id.print -> Toast.makeText(this, "You clicked Print",Toast.LENGTH_SHORT).show()
            R.id.mail -> Toast.makeText(this,"You clicked Email",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}