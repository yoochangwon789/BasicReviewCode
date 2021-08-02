package com.yoochangwonspro.basicreviewcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_practice_lotto_project)

        numberPicker.minValue = 1
        numberPicker.maxValue = 45

        addButton()
    }

    private fun addButton(){
        lottoAddButton.setOnClickListener {

            if (primaryLottoNumberSet.contains(numberPicker.value)) {
                Toast.makeText(this, "중복된 번호는 사용할 수 없습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            primaryLottoNumberSet.add(numberPicker.value)
            val lottoTextNumber = lottoNumberList[primaryLottoNumberSet.size - 1]
            lottoTextNumber.text = numberPicker.value.toString()
            lottoTextNumber.isVisible = true
        }
    }
}