package com.oakil.notessqlite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class NotesAdapter(private var notes: List<Note>, context: Context) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
        NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        )

    override fun getItemCount(): Int = notes.size


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note  = notes[position]
        holder.titleTextView.text = note.title
        holder.contentTextView.text  = note.content

    }


    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val contentTextView : TextView = itemView.findViewById(R.id.contentTextView)

    }

    fun refreshData(newNotes: List<Note>){
        notes = newNotes
        notifyDataSetChanged()

    }


}