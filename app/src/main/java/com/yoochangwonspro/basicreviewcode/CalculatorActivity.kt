package com.yoochangwonspro.basicreviewcode

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

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

        if (isOperator) {
            expressionTextView.append(" ")
        }
        isOperator = false

        val expressionTexts = expressionTextView.text.split(" ")

        if (expressionTexts.isNotEmpty() && expressionTexts.last().length >= 15) {
            Toast.makeText(this, "15자리 까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        if (expressionTexts.first().isEmpty() && number == "0") {
            Toast.makeText(this, "0은 첫째자리에 올 수 없습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        if (expressionTexts.last().isEmpty() && number == "0") {
            Toast.makeText(this, "0은 첫째자리에 올 수 없습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        expressionTextView.append(number)

        resultTextView.text = calculatorExpression()
    }

    @SuppressLint("SetTextI18n")
    private fun calculatorOperatorButton(operator: String) {

        if (expressionTextView.text.isEmpty()) {
            return
        }

        when {
            isOperator -> {
                val text = expressionTextView.text.toString().dropLast(1) + operator
                expressionTextView.text = text
            }
            hasOperator -> {
                Toast.makeText(this, "연산자는 2개는 사용할 수 없습니다.", Toast.LENGTH_SHORT).show()
                return
            }
            else -> {
                expressionTextView.append(" $operator")
            }
        }

        val ssp = SpannableStringBuilder(expressionTextView.text)
        ssp.setSpan(
            ForegroundColorSpan(getColor(R.color.expressionButton)),
            expressionTextView.text.length - 1,
            expressionTextView.text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        expressionTextView.text = ssp

        isOperator = true
        hasOperator = true
    }

    private fun calculatorExpression(): String {
        val expressionTexts = expressionTextView.text.split(" ")

        if (hasOperator.not() || expressionTexts.size != 3) {
            return ""
        }
        if (expressionTexts[0].isNumber().not() || expressionTexts[2].isNumber().not()) {
            return ""
        }

        val firstNumber = expressionTexts[0].toBigInteger()
        val secondNumber = expressionTexts[2].toBigInteger()
        val op = expressionTexts[1]

        return when (op) {
            "+" -> (firstNumber + secondNumber).toString()
            "-" -> (firstNumber - secondNumber).toString()
            "*" -> (firstNumber * secondNumber).toString()
            "/" -> (firstNumber / secondNumber).toString()
            "%" -> (firstNumber % secondNumber).toString()
            else -> ""
        }
    }

    fun calculatorClearButton(v: View) {
        expressionTextView.text = ""
        resultTextView.text = ""
        isOperator = false
        hasOperator = false
    }

    fun calculatorResultButton(v: View) {

    }

    fun calculatorHistoryButton(v: View) {

    }
}

fun String.isNumber(): Boolean {
    return try {
        this.toBigInteger()
        true
    } catch (e: NumberFormatException) {
        false
    }
}