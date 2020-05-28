package com.example.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calories.*

class CaloriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories)

        val adapter = ArrayAdapter.createFromResource(this, R.array.gender, R.layout.support_simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        genderSpinner.setAdapter(adapter)

        calculateCalories.setOnClickListener() {
            if (ageCalories.getText().length > 0 && weightCalories.getText().length > 0 && heightCalories.getText().length > 0) {
                CalculateCalories()
            } else {
                Toast.makeText(this@CaloriesActivity, "Uzupełnij wszystkie dane", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun CalculateCalories() {
        when (genderSpinner.selectedItem){
            "Mężczyzna" -> resultCalories.text = calcForMale().toString()
            "Kobieta" -> resultCalories.text = calcForFemale().toString()
        }
    }

    fun calcForMale(): Double {
        return ((66.5 + 13.75 * weightCalories.text.toString().toDouble()
                + 5.003 * heightCalories.text.toString().toDouble())
                - 6.775 * ageCalories!!.text.toString().toDouble())
    }

    fun calcForFemale(): Double {
        return ((655.1 + 9.563 * weightCalories.text.toString().toDouble()
                + 1.85 * heightCalories.text.toString().toDouble())
                - 4.676 * ageCalories.text.toString().toDouble())
    }
}