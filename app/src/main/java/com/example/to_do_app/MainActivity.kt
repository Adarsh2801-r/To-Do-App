package com.example.to_do_app

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var item:ArrayList<String>
    private lateinit var itemAdapter:ArrayAdapter<String>
    private lateinit var listview:ListView
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listview = findViewById(R.id.listView)
        button = findViewById(R.id.additem)

        button.setOnClickListener {
            addItem(it)
        }
        item = ArrayList()
        itemAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item)
        listview.adapter = itemAdapter
        ListViewlistener();




    }

    private fun ListViewlistener() {
        listview.setOnItemClickListener{parent,view,position,id:Long->
            val context:Context = applicationContext
            Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show()
            item.removeAt(position)
            itemAdapter.notifyDataSetChanged()


        }
    }


    private fun addItem(it: View?) {
        var info:EditText = findViewById(R.id.info)
        var text = info.text.toString()
        if(text != ""){
            itemAdapter.add(text)
            info.setText("")
        }
        else{
            Toast.makeText(applicationContext,"Please enter text!",Toast.LENGTH_LONG).show()
        }

    }
}
