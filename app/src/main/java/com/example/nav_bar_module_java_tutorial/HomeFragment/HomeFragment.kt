package com.example.nav_bar_module_java_tutorial.HomeFragment

import android.content.ContentProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat
import com.example.nav_bar_module_java_tutorial.databinding.FragmentHomeBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nav_bar_module_java_tutorial.R
import com.example.nav_bar_module_java_tutorial.TutorialFragment.TutorialFragment

class HomeFragment : Fragment() {
    private var progr = 60
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val PREF_NAME = "quiz_data"
    val KEY_DATE = "date"
    val KEY_BEGINNER_SCORE = "beginner_score"
    val KEY_INTERMEDIATE_SCORE = "intermediate_score"
    val KEY_EXPERT_SCORE = "expert_score"
    val KEY_BEGINNER_COUNT = "beginner_count"
    val KEY_INTERMEDIATE_COUNT = "intermediate_count"
    val KEY_EXPERT_COUNT = "expert_count"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using View Binding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.programOpen.setOnClickListener {
//            // Navigate to the ProgTaskFragment
//            findNavController().navigate(R.id.action_homeFragment_to_tutorialFragment)
//        }
        // Inside your fragment or activity




        // Hide ActionBar
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        // Your other View Binding related code here
        binding.progressBar8.progress = progr


// Get the Drawable from the TextView's compound drawables
        val drawable = binding.text2.compoundDrawables[0]
        val drawable2 = binding.text4.compoundDrawables[0]
        val drawable_clock = binding.date.compoundDrawables[0]

// Set the width and height for the drawable (adjust values as needed)
        drawable?.setBounds(0, 0, 50, 50)
        drawable2?.setBounds(0, 0, 50, 50)
        drawable_clock?.setBounds(0, 0, 50, 50)

// Set the updated compound drawables back to the TextView
        binding.text2.setCompoundDrawables(drawable, null, null, null)
        binding.text4.setCompoundDrawables(drawable2, null, null, null)
        binding.date.setCompoundDrawables(drawable_clock, null, null, null)
        binding.text2.visibility= View.VISIBLE
        binding.text4.visibility= View.VISIBLE
        binding.date.visibility= View.VISIBLE


        val sharedPreferences = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val date = sharedPreferences.getString(KEY_DATE, "")
        val beginnerScore = sharedPreferences.getInt(KEY_BEGINNER_SCORE, 0)
        val intermediateScore = sharedPreferences.getInt(KEY_INTERMEDIATE_SCORE, 0)
        val expertScore = sharedPreferences.getInt(KEY_EXPERT_SCORE, 0)
        val beginnerCount = sharedPreferences.getInt(KEY_BEGINNER_COUNT, 0)
        val intermediateCount = sharedPreferences.getInt(KEY_INTERMEDIATE_COUNT, 0)
        val expertCount = sharedPreferences.getInt(KEY_EXPERT_COUNT, 0)
        val avg=(beginnerScore+intermediateScore+expertScore)/3
        binding.date.text=date
        binding.textBeginnerScore.text="Score : $beginnerScore %"
        binding.textIntermediateScore.text="Score : $intermediateScore %"
        binding.textExpertScore.text="Score : $expertScore %"
        binding.seekbarBegginer.progress=beginnerScore
        binding.seekbarExpert.progress=expertScore
        binding.seekbarIntermediate.progress=intermediateScore
        binding.seekbarAvgScore.progress=avg
        binding.avgScore.text="Score : $avg %"

        val text = when {
            avg >= 90.0 -> "Great"
            avg >= 70.0 -> "Good"
            avg >= 60.0 -> "Average"
            avg >= 40.0 -> "Below Average"
            else -> "Not Good"
        }

// Set the TextView text
        binding.textAvgBest.text = "Performance: $text"


    }

    // Rest of your HomeFragment code
}
