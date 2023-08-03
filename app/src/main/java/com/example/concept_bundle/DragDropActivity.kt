package com.example.concept_bundle

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.View.DragShadowBuilder
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.concept_bundle.databinding.ActivityDragDropBinding

class DragDropActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_drop)

        val dragview = findViewById<View>(R.id.view_drag)
        dragview.setOnLongClickListener(){
            val cliptext = "Sample Text"
            val item = ClipData.Item(cliptext)
            val mimetype = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(cliptext,mimetype,item)
            val dragshadow = DragShadowBuilder(it)
            it.startDragAndDrop(data,dragshadow,it,0)
            true
        }

        val parentview = findViewById<View>(R.id.ParentLinear)
        val draglistener = parentview.setOnDragListener { view, event ->
            when(event.action){
                DragEvent.ACTION_DRAG_STARTED -> {
                    event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DRAG_LOCATION -> {
                    true
                }
                DragEvent.ACTION_DRAG_EXITED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DROP -> {
                    val v = event.localState as View
                    val parent = v.parent as ViewGroup
                    parent.removeView(v)

                    val destination = view as LinearLayout
                    destination.addView(view)
                    view.visibility = View.VISIBLE
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}