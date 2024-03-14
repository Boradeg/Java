package com.example.nav_bar_module_java_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuizStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_start)
        supportActionBar?.hide()
    }
}