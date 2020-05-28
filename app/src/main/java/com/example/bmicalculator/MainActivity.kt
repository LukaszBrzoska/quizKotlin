package com.example.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var height: EditText? = null
    private var weight: EditText? = null
    private var result: TextView? = null
    private var calculate: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        height = findViewById(R.id.height)
        weight = findViewById(R.id.weight)
        result = findViewById(R.id.result)
        calculate = findViewById(R.id.calculate)
    }

    fun calculateBMI(v: View) {
        val heightStr = height!!.text.toString()
        val weightStr = weight!!.text.toString()
        if (heightStr != null && "" != heightStr
                && weightStr != null && "" != weightStr) {
            val heightValue = heightStr.toFloat() / 100
            val weightValue = weightStr.toFloat()
            val bmi = weightValue / (heightValue * heightValue)
            displayBMI(bmi)
        }
    }

    private fun displayBMI(bmi: Float) {
        var bmiDisplay = ""
        bmiDisplay = if (java.lang.Float.compare(bmi, 15f) <= 0) {
            getString(R.string.wyglodzenie)
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 16f) <= 0) {
            getString(R.string.wychudzenie)
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 18.5f) <= 0) {
            getString(R.string.niedowaga)
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 25f) <= 0) {
            getString(R.string.pozadana_masa_ciala)
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 30f) <= 0) {
            getString(R.string.nadwaga)
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 35f) <= 0) {
            getString(R.string.otylosc_I_stopnia)
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 40f) <= 0) {
            getString(R.string.otylosc_II_stopnia)
        } else {
            getString(R.string.otylosc_III_stopnia)
        }
        bmiDisplay = bmi.toString() + "\n\n" + bmiDisplay
        result!!.text = bmiDisplay
    }
}