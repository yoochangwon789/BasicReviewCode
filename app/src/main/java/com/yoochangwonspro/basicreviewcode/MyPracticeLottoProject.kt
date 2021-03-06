package com.yoochangwonspro.basicreviewcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MyPracticeLottoProject : AppCompatActivity() {

    private val numberPicker: NumberPicker by lazy {
        findViewById(R.id.lotto_number_picker)
    }

    private val lottoAddButton: Button by lazy {
        findViewById(R.id.lotto_add_btn)
    }

    private val lottoRemoveButton: Button by lazy {
        findViewById(R.id.lotto_remove_btn)
    }

    private val lottoResetButton: Button by lazy {
        findViewById(R.id.lotto_reset_btn)
    }

    private val lottoRandomButton: Button by lazy {
        findViewById(R.id.lotto_random_btn)
    }

    private val lottoNumberList: List<TextView> by lazy {
        listOf(
            findViewById(R.id.lotto_number_one),
            findViewById(R.id.lotto_number_two),
            findViewById(R.id.lotto_number_three),
            findViewById(R.id.lotto_number_four),
            findViewById(R.id.lotto_number_five),
            findViewById(R.id.lotto_number_six),
        )
    }

    private val primaryLottoNumberSet = mutableSetOf<Int>()

    private var checkLottoSystem: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_practice_lotto_project)

        numberPicker.minValue = 1
        numberPicker.maxValue = 45

        addButton()
        lottoResetButton()
        lottoRandomNumberButton()
        lottoRemoveButton()
    }

    private fun addButton() {
        lottoAddButton.setOnClickListener {

            if (primaryLottoNumberSet.size >= 5) {
                Toast.makeText(this, "5개 까지 추가가 가능합니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (primaryLottoNumberSet.contains(numberPicker.value)) {
                Toast.makeText(this, "중복된 번호는 사용할 수 없습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (checkLottoSystem) {
                Toast.makeText(this, "번호를 추가할 수 없습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            primaryLottoNumberSet.add(numberPicker.value)
            val lottoTextNumber = lottoNumberList[primaryLottoNumberSet.size - 1]
            lottoTextNumber.text = numberPicker.value.toString()
            lottoTextNumber.isVisible = true

            lottoBackGroundNumber(numberPicker.value, lottoTextNumber)
        }
    }

    private fun lottoBackGroundNumber(value: Int, textView: TextView) {
        when (value) {
            in 1..10 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_blue)
            in 11..20 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_red)
            in 21..30 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_gray)
            in 31..40 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_pupple)
            else -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_green)
        }
    }

    private fun lottoRandomNumberButton() {
        lottoRandomButton.setOnClickListener {
            val randomList = randomNumberSetList()

            randomList.forEachIndexed { index, i ->
                val lottoTextNumber = lottoNumberList[index]
                lottoTextNumber.text = i.toString()
                lottoTextNumber.isVisible = true

                lottoBackGroundNumber(i, lottoTextNumber)

                checkLottoSystem = true
            }
        }
    }

    private fun randomNumberSetList(): List<Int> {
        val randomNumberList = mutableListOf<Int>()

        if (primaryLottoNumberSet.isEmpty()) {
            for (i in 1..45) {
                randomNumberList.add(i)
            }
            randomNumberList.shuffle()
            val newList = randomNumberList.subList(0, 6)
            newList.sort()

            return newList
        } else {
            for (i in 1..45) {
                if (primaryLottoNumberSet.contains(i)) continue
                randomNumberList.add(i)
            }
            randomNumberList.shuffle()

            val newList = primaryLottoNumberSet.toMutableList() + randomNumberList.subList(0,
                6 - primaryLottoNumberSet.size)

            return newList.sorted()
        }
    }

    private fun lottoResetButton() {
        lottoResetButton.setOnClickListener {
            lottoNumberList.forEach {
                it.isVisible = false
            }
            primaryLottoNumberSet.clear()
            checkLottoSystem = false
        }
    }

    private fun lottoRemoveButton() {
        lottoRemoveButton.setOnClickListener {

            if (checkLottoSystem) {
                Toast.makeText(this, "초기화 버튼을 사용해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else {
                val textViewIndex = lottoNumberList[primaryLottoNumberSet.size - 1]
                val setIndex = primaryLottoNumberSet.size

                Log.d("textViewIndex", "$textViewIndex")
                Log.d("setIndex", "$setIndex")

                textViewIndex.isVisible = false
                primaryLottoNumberSet.remove(setIndex)
            }
        }
    }
}