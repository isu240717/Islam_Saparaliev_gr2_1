package com.example.taskapp53.ui.home.new_task

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.taskapp53.R
import com.example.taskapp53.databinding.FragmentNewTaskBinding

class NewTaskFragment : Fragment() {

    private lateinit var bindinhg : FragmentNewTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindinhg = FragmentNewTaskBinding.inflate(inflater, container, false)

        initViews()
        initListeners()

        return bindinhg.root
    }

    private fun initListeners() {
        bindinhg.btnSave.setOnClickListener {
            setFragmentResult("new_task", bundleOf(
                "title" to bindinhg.etTitle.text.toString(),
                "desc" to bindinhg.etDesc.text.toString()
            ))
            findNavController().navigateUp()
        }
    }

    private fun initViews() {

    }
}