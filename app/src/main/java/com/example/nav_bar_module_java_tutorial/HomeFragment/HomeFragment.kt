package com.example.nav_bar_module_java_tutorial.HomeFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nav_bar_module_java_tutorial.databinding.FragmentHomeBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    private var progr = 60
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

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
        // Hide ActionBar
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        // Your other View Binding related code here
        binding.progressBar8.progress = progr


// Get the Drawable from the TextView's compound drawables
        val drawable = binding.text2.compoundDrawables[0]
        val drawable2 = binding.text4.compoundDrawables[0]
        val drawable_clock = binding.clock.compoundDrawables[0]

// Set the width and height for the drawable (adjust values as needed)
        drawable?.setBounds(0, 0, 50, 50)
        drawable2?.setBounds(0, 0, 50, 50)
        drawable_clock?.setBounds(0, 0, 50, 50)

// Set the updated compound drawables back to the TextView
        binding.text2.setCompoundDrawables(drawable, null, null, null)
        binding.text4.setCompoundDrawables(drawable2, null, null, null)
        binding.clock.setCompoundDrawables(drawable_clock, null, null, null)
        binding.text2.visibility= View.VISIBLE
        binding.text4.visibility= View.VISIBLE
        binding.clock.visibility= View.VISIBLE

        //startActivity on click
//        binding.programOpen.setOnClickListener {
//            findNavController().navigate(R.id.action_navigation_home_to_navigation_tutorial)
//        }

    }

    // Rest of your HomeFragment code
}
