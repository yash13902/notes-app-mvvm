package com.example.notes.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notes.data.db.entities.NoteItem
import com.example.notes.databinding.FragmentNewNoteBinding
import com.example.notes.util.TAG

class NewNoteFragment : Fragment() {

    private val sharedViewModel: NoteViewModel by activityViewModels()

    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!
    private val args: NewNoteFragmentArgs by navArgs()
    private var noteItem: NoteItem? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        noteItem = args.noteItem
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteItem?.let {
            with(binding) {
                etTitle.setText(it.title)
                etDesc.setText(it.description)
                cbLock.isChecked = it.lock
            }
        }

        binding.fabCreate.setOnClickListener {
            with(binding) {
                val temp = NoteItem(
                    title = etTitle.text.toString(),
                    description = etDesc.text.toString(),
                    lock = cbLock.isChecked
                )
                if (noteItem != null) {
                    temp.id = noteItem!!.id
                    sharedViewModel.update(temp)
                } else {
                    Log.i(TAG, "onViewCreated: Item added")
                    sharedViewModel.insert(temp)
                }
                findNavController().popBackStack()
            }
        }
    }
}