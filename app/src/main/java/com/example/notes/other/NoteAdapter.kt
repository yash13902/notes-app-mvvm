package com.example.notes.other

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.notes.data.db.entities.NoteItem
import com.example.notes.other.NoteViewHolder.Companion.create

class NoteAdapter(
    private val noteItemClickListener: NoteItemClickListener
): ListAdapter<NoteItem, NoteViewHolder>(DiffCallback) {

    companion object DiffCallback: DiffUtil.ItemCallback<NoteItem>(){
        override fun areItemsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return create(parent)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position), noteItemClickListener)
    }

}