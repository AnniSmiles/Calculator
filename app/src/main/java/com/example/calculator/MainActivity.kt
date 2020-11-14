package com.example.calculator

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)


    }

    fun numberClick(view: View) {
        if (view is TextView) {
            var result: String = resultTextView.text.toString()
            val number: String = view.text.toString()
            if (result == "0") {
                result = ""
            }
            resultTextView.text = result + number

        }
    }

    fun operationClick(view: View) {
        if (view is TextView) {
            if (!TextUtils.isEmpty(resultTextView.text)) {
                operand = resultTextView.text.toString().toDouble()
            }
            operation = view.text.toString()
            resultTextView.text = ""
        }
    }

    fun equalsClick(view: View) {
        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0
        if (!TextUtils.isEmpty(secOperandText)) {
            secOperand = secOperandText.toDouble()
        }
        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()

        }
    }

    fun clearClick(view: View) {
        operand = 0.0
        operation = ""
        resultTextView.text = ""

    }

    fun delClick(view: View) {
        val result1 = resultTextView.text.toString()
        if (!TextUtils.isEmpty(resultTextView.text)) {
            resultTextView.text = result1.substring(0, result1.length - 1)
        }
    }


    fun dotClick(view: View) {
        val str = resultTextView.text.toString().trim()
        if (str.isNotEmpty()) {
             resultTextView.text = ("$str.")
        }
        else {
            resultTextView.text=("0.")
        }
    }
}