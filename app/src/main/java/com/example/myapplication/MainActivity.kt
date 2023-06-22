package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvInputText: TextView? = null
    private var lastNumeric: Boolean = false
    private var lastDot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInputText = findViewById(R.id.tvInput)
    }

    /**
     * @author Ömer Aynaci
     * if an digit is being clicked then add the textView of the button
     * e.g if you click the 9 button then the 9 will be displayed
     */
    fun onDigit(view: View) {
        tvInputText?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    /**
     * @author Ömer Aynaci
     * when clicking the clear button then it clears the text
     */
    fun onClear(view: View) {
        tvInputText?.text = ""
    }

    /**
     * @author Ömer Aynaci
     * checking if the last numeric is true and last dot is false
     * then don't add another dot
     */
    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            tvInputText?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    /**
     * @author Ömer Aynaci
     * checking if the textView is empty if so then append the view of the button
     * e.g the plus button or de minus button etc
     */
    fun onOperator(view: View) {
        tvInputText?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())) {
                tvInputText?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }

    }

    /**
     * @author Ömer Aynaci
     * checking if an operator starts with an operator for example with an - or an +
     * @return boolean
     */
    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
}