package com.example.nav_bar_module_java_tutorial.QuizFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nav_bar_module_java_tutorial.R
import com.example.nav_bar_module_java_tutorial.databinding.ActivityMainBinding
import com.example.nav_bar_module_java_tutorial.databinding.ActivityQuizStartBinding

class QuizStartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityQuizStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.icon
        supportActionBar?.hide()

    }
}