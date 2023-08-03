package com.example.concept_bundle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FragmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        val firstfragment = FirstFragment()
        val secondfragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment, firstfragment)
            commit()
        }
        val btnpre = findViewById<Button>(R.id.btnfirst)
        btnpre.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flfragment, firstfragment)
                addToBackStack("First fragment")
                commit()
            }
        }

        val btnnext = findViewById<Button>(R.id.btnsecond)
        btnnext.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flfragment, secondfragment)
                addToBackStack("Second fragment")
                commit()
            }
        }
    }
}