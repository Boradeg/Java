package com.example.nav_bar_module_java_tutorial.QuizFragment
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nav_bar_module_java_tutorial.databinding.ActivityQuizStartBinding
import kotlin.random.Random

class QuizStartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizStartBinding
    private lateinit var questionList: List<QuizQuestion>
    private var currentQuestionIndex: Int = 0
    private val quizDBHelper = QuizDBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // Retrieve extra data from the Intent
        val quizNumber = intent.getIntExtra("quiz_number", 0)
        val difficultyLevel = intent.getStringExtra("difficulty_level")

        // Add questions to the database if not already added
        addQuestionsToDatabaseIfNotAdded()

        // Handle option clicks
        binding.option1.setOnClickListener { handleOptionClick(1) }
        binding.option2.setOnClickListener { handleOptionClick(2) }
        binding.option3.setOnClickListener { handleOptionClick(3) }
        binding.option4.setOnClickListener { handleOptionClick(4) }

        // Display the first question
        displayQuestion(currentQuestionIndex)
    }

    private fun addQuestionsToDatabaseIfNotAdded() {
        if (!areQuestionsAdded()) {
            val questionList = mutableListOf<QuizQuestion>()

            // Add 30 easy questions
            for (i in 1..30) {
                questionList.add(QuizQuestion(i, "Easy Question $i", "Option 1", "Option 2", "Option 3", "Option 4", 1, "easy"))
            }

            // Add 30 medium questions
            for (i in 31..60) {
                questionList.add(QuizQuestion(i, "Medium Question ${i - 30}", "Option 1", "Option 2", "Option 3", "Option 4", 1, "medium"))
            }

            // Add remaining hard questions
            for (i in 61..100) {
                questionList.add(QuizQuestion(i, "Hard Question ${i - 60}", "Option 1", "Option 2", "Option 3", "Option 4", 1, "hard"))
            }

            for (question in questionList) {
                quizDBHelper.addQuestion(question)
            }
            markQuestionsAsAdded()
        }
    }

    private fun handleOptionClick(selectedOptionIndex: Int) {
        // Disable all option buttons to prevent multiple clicks
        disableOptionButtons()

        // Check if the selected option is correct
        val selectedOption = selectedOptionIndex
        val correctOption = questionList[currentQuestionIndex].correctOption

        // Change the background color of the selected option to black
        setOptionBackgroundColor(selectedOption, "#f44236")

        // Show the correct option with a green background
        setOptionBackgroundColor(correctOption, "#5bb35d")

        // Delay for 2 seconds using Handler
        Handler().postDelayed({
            // Increment the current question index
            currentQuestionIndex++

            // Check if there are more questions
            if (currentQuestionIndex < questionList.size) {
                // Display the next question
                displayQuestion(currentQuestionIndex)
            } else {
                // No more questions, show end of quiz message
                Toast.makeText(this, "End of Quiz", Toast.LENGTH_SHORT).show()

                // Handle end of quiz (e.g., show quiz result or navigate to another activity)
            }

            // Reset the background color of all option buttons
            resetOptionButtonBackgrounds()

            // Enable option buttons again
            enableOptionButtons()
        }, 2000)
    }

    private fun setOptionBackgroundColor(optionIndex: Int, color: String) {
        when (optionIndex) {
            1 -> binding.option1.setBackgroundColor(Color.parseColor(color))
            2 -> binding.option2.setBackgroundColor(Color.parseColor(color))
            3 -> binding.option3.setBackgroundColor(Color.parseColor(color))
            4 -> binding.option4.setBackgroundColor(Color.parseColor(color))
        }
    }

    private fun disableOptionButtons() {
        binding.option1.isEnabled = false
        binding.option2.isEnabled = false
        binding.option3.isEnabled = false
        binding.option4.isEnabled = false
    }

    private fun enableOptionButtons() {
        binding.option1.isEnabled = true
        binding.option2.isEnabled = true
        binding.option3.isEnabled = true
        binding.option4.isEnabled = true
    }

    private fun resetOptionButtonBackgrounds() {
        binding.option1.setBackgroundColor(Color.WHITE)
        binding.option2.setBackgroundColor(Color.WHITE)
        binding.option3.setBackgroundColor(Color.WHITE)
        binding.option4.setBackgroundColor(Color.WHITE)
    }

    private fun areQuestionsAdded(): Boolean {
        val sharedPreferences = getSharedPreferences("APP_PREFS", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("QUESTIONS_ADDED", false)
    }

    private fun markQuestionsAsAdded() {
        val sharedPreferences = getSharedPreferences("APP_PREFS", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("QUESTIONS_ADDED", true).apply()
    }

    private fun displayQuestion(index: Int) {
        questionList = quizDBHelper.getQuestionsByDifficulty("easy") // Change difficulty level here
        val question = questionList[index]
        binding.que.text = question.questionText
        binding.op1.text = question.option1
        binding.op2.text = question.option2
        binding.op3.text = question.option3
        binding.op4.text = question.option4
    }
}

data class QuizQuestion(
    val id: Int,
    val questionText: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctOption: Int,
    val difficultyLevel: String
)

class QuizDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "QuizDatabase"
        private const val TABLE_QUESTIONS = "questionsTable"
        private const val KEY_ID = "id"
        private const val KEY_QUESTION = "question_text"
        private const val KEY_OPTION1 = "option1"
        private const val KEY_OPTION2 = "option2"
        private const val KEY_OPTION3 = "option3"
        private const val KEY_OPTION4 = "option4"
        private const val KEY_CORRECT_OPTION = "correct_option"
        private const val KEY_DIFFICULTY_LEVEL = "difficulty_level"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_QUESTIONS ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$KEY_QUESTION TEXT, $KEY_OPTION1 TEXT, $KEY_OPTION2 TEXT, " +
                "$KEY_OPTION3 TEXT, $KEY_OPTION4 TEXT, $KEY_CORRECT_OPTION INTEGER, $KEY_DIFFICULTY_LEVEL TEXT)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_QUESTIONS")
        onCreate(db)
    }

    fun addQuestion(question: QuizQuestion) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_QUESTION, question.questionText)
            put(KEY_OPTION1, question.option1)
            put(KEY_OPTION2, question.option2)
            put(KEY_OPTION3, question.option3)
            put(KEY_OPTION4, question.option4)
            put(KEY_CORRECT_OPTION, question.correctOption)
            put(KEY_DIFFICULTY_LEVEL, question.difficultyLevel)
        }
        db.insert(TABLE_QUESTIONS, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getQuestionsByDifficulty(difficulty: String): List<QuizQuestion> {
        val questionList = mutableListOf<QuizQuestion>()
        val selectQuery = "SELECT * FROM $TABLE_QUESTIONS WHERE $KEY_DIFFICULTY_LEVEL = ? ORDER BY RANDOM() LIMIT 10"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, arrayOf(difficulty))
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                val questionText = cursor.getString(cursor.getColumnIndex(KEY_QUESTION))
                val option1 = cursor.getString(cursor.getColumnIndex(KEY_OPTION1))
                val option2 = cursor.getString(cursor.getColumnIndex(KEY_OPTION2))
                val option3 = cursor.getString(cursor.getColumnIndex(KEY_OPTION3))
                val option4 = cursor.getString(cursor.getColumnIndex(KEY_OPTION4))
                val correctOption = cursor.getInt(cursor.getColumnIndex(KEY_CORRECT_OPTION))
                val question = QuizQuestion(id, questionText, option1, option2, option3, option4, correctOption, difficulty)
                questionList.add(question)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return questionList
    }
}
