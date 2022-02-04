package com.example.notes.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.data.db.entities.NoteItem
import com.example.notes.databinding.NoteItemBinding

class NoteViewHolder(
    private val binding: NoteItemBinding
): RecyclerView.ViewHolder(binding.root)  {

    fun bind(item: NoteItem, click: NoteItemClickListener){
        with(binding){
            tvTitle.text = item.title
            tvDesc.text = item.description

            ivDelete.setOnClickListener {
                click.onItemClick(item, ClickAction.DELETE)
            }
            root.setOnClickListener {
                click.onItemClick(item, ClickAction.OPEN)
            }
        }
    }

    companion object{
        fun create(parent: ViewGroup): NoteViewHolder{
            val binding = NoteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return NoteViewHolder(binding)
        }
    }
}