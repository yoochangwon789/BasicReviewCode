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

    private fun calculatorButton(v: View) {
        when (v.id) {
            R.id.calculator_zero_btn -> calculatorNumberButton("0")
            R.id.calculator_one_btn -> calculatorNumberButton("1")
            R.id.calculator_two_btn -> calculatorNumberButton("2")
            R.id.calculator_three_btn -> calculatorNumberButton("3")
            R.id.calculator_four_btn -> calculatorNumberButton("4")
            R.id.calculator_five_btn -> calculatorNumberButton("5")
            R.id.calculator_six_btn -> calculatorNumberButton("6")
            R.id.calculator_seven_btn -> calculatorNumberButton("7")
            R.id.calculator_eight_btn -> calculatorNumberButton("8")
            R.id.calculator_nine_btn -> calculatorNumberButton("9")
            R.id.calculator_plus_btn -> calculatorOperatorButton("+")
            R.id.calculator_minus_btn -> calculatorOperatorButton("-")
            R.id.calculator_multi_btn -> calculatorOperatorButton("*")
            R.id.calculator_divider_btn -> calculatorOperatorButton("/")
            R.id.calculator_modulo_btn -> calculatorOperatorButton("%")
        }
    }

    private fun calculatorNumberButton(number: String) {

    }

    private fun calculatorOperatorButton(operator: String) {

    }

    private fun calculatorClearButton(v: View) {

    }

    private fun calculatorResultButton(v: View) {

    }

    fun calculatorHistoryButton(v: View) {

    }
}