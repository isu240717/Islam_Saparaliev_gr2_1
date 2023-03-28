package com.example.taskapp53.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskapp53.R
import com.example.taskapp53.databinding.FragmentHomeBinding
import com.example.taskapp53.ui.home.new_task.TaskAdapter

class HomeFragment : Fragment() {

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initViews()
        initListeners()

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskAdapter = TaskAdapter()
    }

    private fun initListeners() {
        binding.fabHome.setOnClickListener {
            findNavController().navigate(R.id.newTaskFragment)
        }
    }

    private fun initViews() {

        binding.rvHome.layoutManager = LinearLayoutManager(context)
        binding.rvHome.adapter = taskAdapter

        setFragmentResultListener("new_task") { key, bundle ->
            Log.e(
                "ololo", "initViews: " + bundle.getString("title")
                        + bundle.getString("desc")
            )

            val title = bundle.getString("title")
            val desc = bundle.getString("desc")
            taskAdapter.addTask(
                TaskModel(
                    title.toString(),
                    desc.toString()
                )
            )
        }
    }
}