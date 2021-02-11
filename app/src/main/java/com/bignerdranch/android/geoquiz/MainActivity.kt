package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trueButton: Button = findViewById(R.id.true_button);
        val falseButton: Button = findViewById(R.id.false_button);

        trueButton.setOnClickListener {
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).apply {
                setGravity(Gravity.TOP, 0, 0)
                show()
            }
        }

        falseButton.setOnClickListener {
            // it's the standard of functional programming.
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).apply {
                setGravity(Gravity.TOP, 0, 0)
                show()
            }
        }
    }

}