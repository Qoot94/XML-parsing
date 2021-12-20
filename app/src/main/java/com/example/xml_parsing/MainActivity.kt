package com.example.xml_parsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var tvMain: TextView
    private var students = ArrayList<Students>()
    lateinit var myRV: RecyclerView
    lateinit var rvAdapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myRV = findViewById(R.id.rvMain)

        try {
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("students.xml")
            students = parser.parse(iStream)
            rvAdapter = RVAdapter(students)
            myRV.adapter = rvAdapter
            myRV.layoutManager = LinearLayoutManager(this)
        } catch (e: IOException) {
            println("ISSUE: $e")
        }
    }
}