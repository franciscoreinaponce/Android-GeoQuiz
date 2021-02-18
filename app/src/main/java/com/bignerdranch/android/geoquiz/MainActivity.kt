package com.bignerdranch.android.geoquiz

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trueButton: Button = findViewById(R.id.true_button)
        val falseButton: Button = findViewById(R.id.false_button)
        val nextButton: Button = findViewById(R.id.next_button)
        val questionTextView: TextView = findViewById(R.id.question_text_view)

        // Question: Is it possible call checkAnswer sending the value chose and returning back the correct toast?
        // (inserting the call in  R.string.correct_toast position)
//        trueButton.setOnClickListener {
//            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).apply {
//                setGravity(Gravity.TOP, 0, 0)
//                show()
//            }
//        }

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            // it's the standard of functional programming.
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion(questionTextView)
        }

        updateQuestion(questionTextView)
    }

    private fun updateQuestion(questionTextView: TextView) {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId) // how this line works?
    }

    // Question: could this method be called from true/falseButton.setOnClickListener?
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        // Question: is not possible to use ? operator?
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

}
