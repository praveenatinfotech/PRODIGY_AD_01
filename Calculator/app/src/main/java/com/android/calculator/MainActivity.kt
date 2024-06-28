package com.example.calculator

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var tvResult: TextView? = null
    private var currentInput = ""
    private var operator = ""
    private var firstOperand = Double.NaN
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult = findViewById(R.id.tvResult)
    }

    fun onDigitClick(view: View) {
        val button = view as Button
        currentInput += button.text.toString()
        tvResult!!.text = currentInput
    }

    fun onOperatorClick(view: View) {
        if (!java.lang.Double.isNaN(firstOperand)) {
            performOperation()
        } else {
            firstOperand = currentInput.toDouble()
        }
        val button = view as Button
        operator = button.text.toString()
        currentInput = ""
    }

    fun onClearClick(view: View?) {
        currentInput = ""
        operator = ""
        firstOperand = Double.NaN
        tvResult!!.text = "0"
    }

    fun onEqualClick(view: View?) {
        performOperation()
        operator = ""
    }

    private fun performOperation() {
        val secondOperand = currentInput.toDouble()
        var result = 0.0
        when (operator) {
            "+" -> result = firstOperand + secondOperand
            "-" -> result = firstOperand - secondOperand
            "*" -> result = firstOperand * secondOperand
            "/" -> result = firstOperand / secondOperand
        }
        firstOperand = result
        currentInput = result.toString()
        tvResult!!.text = currentInput
    }
}
