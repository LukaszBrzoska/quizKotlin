package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        buttonCalories.setOnClickListener() {
                runCaliriesCalculator()
            }
        buttonBMI.setOnClickListener() {
            runBmiCalculator()
        }
        buttonQuiz.setOnClickListener() {
            runQuiz()
        }

    }

    private fun runQuiz() {
        val quiz = Intent(this, QuizActivity::class.java)
        startActivity(quiz)
    }

    private fun runBmiCalculator() {
        val bmi = Intent(this, MainActivity::class.java)
        startActivity(bmi)
    }

    private fun runCaliriesCalculator() {
        val calories = Intent(this, CaloriesActivity::class.java)
        startActivity(calories)
    }


}
