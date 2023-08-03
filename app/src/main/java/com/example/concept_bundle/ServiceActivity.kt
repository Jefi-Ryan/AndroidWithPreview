package com.example.concept_bundle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        var start = findViewById<Button>(R.id.btnStartService)
        var stop = findViewById<Button>(R.id.btnStopService)
        var send = findViewById<Button>(R.id.btnSendDatatoService)
        var service_status = findViewById<TextView>(R.id.tvServiceStatus)
        var service_data = findViewById<EditText>(R.id.etDataforService)
        start.setOnClickListener {
            Intent(this,MyService :: class.java).also {
                service_status.text = "Service running"
                startService(it)
            }
        }
        stop.setOnClickListener {
            Intent(this,MyService :: class.java).also {
                service_status.text = "Service stopped"
                stopService(it)
            }
        }
        send.setOnClickListener {
            Intent(this,MyService :: class.java).also {
                it.putExtra("ServiceData",service_data.text.toString())
                Log.d("Service data", service_data.text.toString())
                service_status.text = "Service running"
                startService(it)
            }
        }

    }
}