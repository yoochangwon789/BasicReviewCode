package com.yoochangwonspro.basicreviewcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView

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
    }
}