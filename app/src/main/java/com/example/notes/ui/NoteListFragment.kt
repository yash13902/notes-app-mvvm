package com.example.notes.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.util.TAG
import com.example.notes.data.db.entities.NoteItem
import com.example.notes.databinding.FragmentNoteListBinding
import com.example.notes.other.ClickAction
import com.example.notes.other.NoteAdapter
import com.example.notes.other.NoteItemClickListener

class NoteListFragment : Fragment(), NoteItemClickListener {

    private val sharedViewModel: NoteViewModel by activityViewModels()
    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!
    private val noteAdapter = NoteAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotes.adapter = noteAdapter

        sharedViewModel.getAllNotes().observe(viewLifecycleOwner, {
            Log.i(TAG, "onViewCreated: List Changed $it")
            noteAdapter.submitList(it)
        })

        binding.fabNew.setOnClickListener{
            findNavController().navigate(NoteListFragmentDirections.actionNoteListToNewNote(noteItem = null))
        }
    }

    override fun onItemClick(notesItem: NoteItem, action: ClickAction) {
        when(action){
            ClickAction.OPEN ->
                findNavController().navigate(NoteListFragmentDirections.actionNoteListToNewNote(noteItem = notesItem))
            ClickAction.DELETE -> {
                sharedViewModel.delete(notesItem)
                Toast.makeText(requireContext(), "Note Deleted!", Toast.LENGTH_SHORT).show()
            }

        }
    }

}