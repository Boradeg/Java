package com.example.nav_bar_module_java_tutorial.QuizFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nav_bar_module_java_tutorial.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {


    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle button click
        binding.startQuizButton.setOnClickListener {
            // Create an Intent to start the activity
            val intent = Intent(activity, QuizStartActivity::class.java)

            // Optionally, you can pass data to the activity
            // intent.putExtra("key", "value")

            // Start the activity
            startActivity(intent)
        }
    }
    }
