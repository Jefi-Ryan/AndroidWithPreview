package com.example.concept_bundle

import android.content.Context
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        var data = mutableListOf<Note>(
            Note("Hi this is Jefi", false),
            Note("Hi this is Ryan", true),
            Note("Hi there!", false),
        )

        //shared preferences
        val sharedpref = getSharedPreferences("Notesdata", MODE_PRIVATE)
        val editor = sharedpref.edit()
        val testing : Int = sharedpref.getInt("counter",-1)
        if(testing == -1){
            editor.apply{
                putInt("counter",0)
                apply()
            }
        }
        lateinit var title : String
        var checked = false
        var counter = sharedpref.getInt("counter",-1)

        for(i in 0..counter){
            title = sharedpref.getString("title$i",null) ?: ""
            checked = sharedpref.getBoolean("checked$i",false)
            data.add(Note(title,checked))
        }

        val adapter = NotesAdapter(data)
        val rview = findViewById<RecyclerView>(R.id.rvLayout)
        val textdata = findViewById<EditText>(R.id.etNotesData)
        rview.adapter = adapter
        rview.layoutManager = LinearLayoutManager(this)
        val addbtn = findViewById<Button>(R.id.btnCreateNote)

        addbtn.setOnClickListener {
            data.add(Note(textdata.text.toString(),false))

            //saving in shared preference
            editor.apply{
                putString("title$counter",textdata.text.toString())
                putBoolean("checked$counter",false)
                putInt("counter",counter)
                apply()
                counter++
            }

            adapter.notifyItemInserted(data.size - 1)
            textdata.text.clear()
        }
    }
}