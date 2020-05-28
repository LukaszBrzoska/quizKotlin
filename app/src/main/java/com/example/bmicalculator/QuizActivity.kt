package com.example.bmicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.end_quiz.*
import kotlinx.android.synthetic.main.quiz_layout.*
import java.util.*
import kotlin.collections.ArrayList

class QuizActivity : AppCompatActivity() {
    var numbers = ArrayList<Int>()
    var points = 0
    var round = 0
    var answersList = ArrayList<ArrayList<String>>()
    var questionsList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareQuiz()
    }

    private fun prepareQuiz() {
        setContentView(R.layout.activity_quiz)
        startQuizButton.setOnClickListener(){
            startQuiz()
        }
    }

    private fun startQuiz() {
        setContentView(R.layout.quiz_layout)
        setArrays()
        quiz()

    }

    private fun quiz() {
        button1.setOnClickListener(){ checkRound(1) }
        button2.setOnClickListener(){ checkRound(2) }
        button3.setOnClickListener(){ checkRound(3) }
        button4.setOnClickListener(){ checkRound(4) }
        startRound()
    }

    private fun startRound() {
        round = Random().nextInt(5)
        if (!numbers.contains(round)) {
            numbers.add(round)
            questionView.setText(questionsList.get(round))
            button1.setText(answersList.get(round).get(0).replace("_", " "))
            button2.setText(answersList.get(round).get(1).replace("_", " "))
            button3.setText(answersList.get(round).get(2).replace("_", " "))
            button4.setText(answersList.get(round).get(3).replace("_", " "))
        } else {
            startRound()
        }
    }


    private fun checkRound(number: Int)  {
        if (numbers.size < 5 && number == answersList.get(round).get(4).toInt()) {
            points += 1
            startRound()
        } else if (numbers.size < 5 && number != answersList.get(round).get(4).toInt()) {
            startRound()
        } else if (numbers.size == 5 && number == answersList.get(round).get(4).toInt()) {
            points += 1
            endQuiz()
        } else if (numbers.size == 5 && number != answersList.get(round).get(4).toInt()) {
            endQuiz()
        }
    }


    private fun endQuiz() {
        setContentView(R.layout.end_quiz)
        quizResult.setText("Zdobyłeś " + points + " / " + questionsList.size.toString())

        restartQuizButton.setOnClickListener() {
            val intent = intent
            finish()
            startActivity(intent)
        }

        endGameButton.setOnClickListener() {
            finish()
        }
    }


    private fun setArrays() {
        resources.getStringArray(R.array.questions).forEach { questionsList.add(it) }
        resources.getStringArray(R.array.answers).forEach {
            var trim = it.replace(" ", "")
            val answers: ArrayList<String> = trim.split(".") as ArrayList<String>
            answersList.add(answers)
        }
    }
}