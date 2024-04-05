package com.example.st10460535.historyapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val compareButton = findViewById<Button>(R.id.compareButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        compareButton.setOnClickListener {
            val userInput = ageEditText.text.toString()

            if (userInput.isEmpty()) {
                resultTextView.text = "Please enter a valid age – it must be a whole number without any decimals or text."
            }

            val userAge = userInput.toIntOrNull()

            if (userAge == null) {
                resultTextView.text = "Please enter a valid age – it must be a whole number without any decimals or text."
            } else {
                if (userAge < 20 || userAge > 100) {
                    resultTextView.text = "Please enter an age between 20 and 100."
                    ageEditText.text.clear()
                } else {
                    val result = when (userAge) {
                        27 -> "Henry Mosely, famous for discovering that each chemical element’s identity is dependent on the number of protons in nucleus, died at the age of 27."
                        36 -> "Ada Lovelace, famous for being the first computer programmer, died at the age of 36."
                        41 -> "Alan Turing, famous for being considered the father of AI and computer science with his Turing test purported to exhibit human-like behaviors, died at the age of 41."
                        else -> "Nobody known to me died at this age"
                    }
                    resultTextView.text = result
                }
            }
        }

        clearButton.setOnClickListener {
            ageEditText.text.clear()
            resultTextView.text = ""
        }
    }
}
