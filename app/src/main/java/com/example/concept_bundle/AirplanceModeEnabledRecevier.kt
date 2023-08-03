package com.example.concept_bundle

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplanceModeEnabledRecevier : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val enabled = intent?.getBooleanExtra("state",false) ?: return
        if(enabled) {
            Toast.makeText(context, "Airplane Mode Turned On", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Airplane Mode Turned Off", Toast.LENGTH_SHORT).show()
        }
    }
}