package com.yoochangwonspro.basicreviewcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {

    private val expressionTextView: TextView by lazy {
        findViewById(R.id.calculator_expression_text_view)
    }

    private val resultTextView: TextView by lazy {
        findViewById(R.id.calculator_result_text_view)
    }

    private var isOperator: Boolean = false

    private var hasOperator: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun calculatorButton(v: View) {

    }

    fun calculatorClearButton(v: View) {

    }

    fun calculatorHistoryButton(v: View) {

    }

    fun calculatorResultButton(v: View) {

    }
}