package com.example.concept_bundle

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    var tag = "MyService"
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(tag, "Service running")
        val data = intent?.getStringExtra("ServiceData")
        Log.d(tag, "Data : $data")
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(tag, "Service started")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "Service destroyed")
    }
}