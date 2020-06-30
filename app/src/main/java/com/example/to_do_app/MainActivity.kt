package com.example.to_do_app

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var listview:ListView
    private lateinit var button: Button
    private lateinit var taskViewModel: TaskViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listview = findViewById(R.id.listView)
        button = findViewById(R.id.additem)

        button.setOnClickListener {
            addItem(it)
        }
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskViewModel.itemAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,taskViewModel.item)
        listview.adapter = taskViewModel.itemAdapter
        ListViewlistener();





    }

    private fun ListViewlistener() {
        listview.setOnItemClickListener{parent,view,position,id:Long->
            val context:Context = applicationContext
            Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show()
            taskViewModel.item.removeAt(position)
            taskViewModel.itemAdapter.notifyDataSetChanged()


        }
    }


    private fun addItem(it: View?) {
        var info:EditText = findViewById(R.id.info)
        var text = info.text.toString()
        if(text != ""){
            taskViewModel.itemAdapter.add(text)
            info.setText("")
        }
        else{
            Toast.makeText(applicationContext,"Please enter text!",Toast.LENGTH_LONG).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.clear->{
                clearAll()
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun clearAll(): Boolean {
        taskViewModel.item.clear()
        taskViewModel.itemAdapter.notifyDataSetChanged()

        return true
    }

}
