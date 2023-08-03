package com.example.concept_bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(val notes : List<Note>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>()
{
    inner class NotesViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        holder.itemView.apply {
            val item = findViewById<TextView>(R.id.tvnote)
            val checkitem = findViewById<CheckBox>(R.id.cbNote)
            item.text = notes[position].title
            checkitem.isChecked = notes[position].ischecked
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }


}