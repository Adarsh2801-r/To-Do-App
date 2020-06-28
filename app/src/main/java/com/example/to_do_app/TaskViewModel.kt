package com.example.to_do_app

import android.app.Application
import android.widget.ArrayAdapter
import androidx.lifecycle.AndroidViewModel

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    var item:ArrayList<String> = ArrayList()
    lateinit var itemAdapter: ArrayAdapter<String>

}