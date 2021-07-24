package com.yoochangwonspro.basicreviewcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_lotto_lottery.*

class LottoLotteryActivity : AppCompatActivity() {

    private var checkReset: Boolean = false
    private val pickSetNumber = mutableSetOf<Int>()
    private val numberTextView: List<TextView> by lazy {
        listOf(
            one_Lotto_number,
            two_Lotto_number,
            three_Lotto_number,
            four_Lotto_number,
            five_Lotto_number,
            six_Lotto_number
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotto_lottery)

        number_picker.minValue = 1
        number_picker.maxValue = 45

        initRandomButton()
        initAddButton()
        initClearButton()
        initRemoveButton()
    }

    private fun initAddButton() {
        add_btn.setOnClickListener {
            if (checkReset) {
                Toast.makeText(this, "초기화 버튼을 클릭후 다시 생성해 주세요.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (pickSetNumber.size >= 5) {
                Toast.makeText(this, "숫자를 더이상 추가할 수 없습니다.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (pickSetNumber.contains(number_picker.value)) {
                Toast.makeText(this, "중복된 숫자는 추가가 불가능 합니다.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val textView = numberTextView[pickSetNumber.size]
            textView.text = number_picker.value.toString()
            textView.isVisible = true
            pickSetNumber.add(number_picker.value)
            Log.d("pickNumberAdd", "$pickSetNumber")
            Log.d("pickNumberAdd", "${pickSetNumber.size}")

            testViewBackGround(number_picker.value, textView)
        }
    }

    private fun testViewBackGround(number: Int, textView: TextView) {
        when (number) {
            in 1..10 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_blue)
            in 11..20 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_gray)
            in 21..30 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_red)
            in 31..40 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_pupple)
            else -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_green)
        }
    }

    private fun initClearButton() {
        clear_btn.setOnClickListener {
            checkReset = false

            pickSetNumber.clear()
            numberTextView.forEach {
                it.isVisible = false
            }
        }
    }

    private fun initRandomButton() {
        random_btn.setOnClickListener {
            val randomList = getRandomNumber()

            checkReset = true

            randomList.forEachIndexed { index, number ->

                val textView = numberTextView[index]
                textView.isVisible = true
                textView.text = number.toString()

                testViewBackGround(number, textView)
            }
        }
    }

    private fun getRandomNumber(): List<Int> {
        val numberList = mutableListOf<Int>().apply {
            for (i in 1..45) {
                if (pickSetNumber.contains(i)) continue
                this.add(i)
            }
        }

        numberList.shuffle()

        val checkList = pickSetNumber + numberList.subList(0, 6 - pickSetNumber.size)

        return checkList.sorted()
    }

    private fun initRemoveButton() {
        remove_btn.setOnClickListener {
            val checkTop1: Int = pickSetNumber.size
            val checkTop2: Int = pickSetNumber.size - 1
            val textView = numberTextView[checkTop2]
            textView.isVisible = false

            pickSetNumber.remove(checkTop1)
            pickSetNumber.forEachIndexed { index, i ->
                Log.d("setIndex", "$index")
                Log.d("IndexI", "$i")
            }
            Log.d("pickNumberRemove", "$pickSetNumber")
        }
    }
}