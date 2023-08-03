package com.example.concept_bundle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val home = HomeFragment()
        val message = MessageFragment()
        val contacts = ContactsFragment()



        val bottom_nav_bar = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottom_nav_bar.getOrCreateBadge(R.id.miMessage).apply {
            number = 10
            isVisible = true
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flbotnav, home)
            addToBackStack("Home")
            commit()
        }

        bottom_nav_bar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.miHome -> if(!home.isVisible) replaceFragment(home)
                R.id.miMessage -> if(!message.isVisible) replaceFragment(message, 1)
                R.id.miContacts -> if(!contacts.isVisible) replaceFragment(contacts)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment, badgeNo : Int = 0){
        Log.d("BottomNavigationActivity", "ReplaceFragment func called!")
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flbotnav, fragment)
            val botnavview = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            botnavview.getOrCreateBadge(R.id.miMessage).apply {
                number -= badgeNo
                Log.d("BottomNavigationActivity", "Number : $number")
                if(number == 0){
                    isVisible = false
                }
            }
            commit()
            addToBackStack(null)
        }
    }
}