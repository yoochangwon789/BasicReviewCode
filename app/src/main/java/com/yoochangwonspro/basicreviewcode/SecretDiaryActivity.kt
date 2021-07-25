package com.yoochangwonspro.basicreviewcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker

class SecretDiaryActivity : AppCompatActivity() {

    private val secretNumberPikerOne: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.secret_number_picker_one)
            .apply {
                this.minValue = 1
                this.maxValue = 45
            }
    }

    private val secretNumberPikerTwo: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.secret_number_picker_two)
            .apply {
                this.minValue = 1
                this.maxValue = 45
            }
    }

    private val secretNumberPikerThree: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.secret_number_picker_three)
            .apply {
                this.minValue = 1
                this.maxValue = 45
            }
    }

    private var secretCheckPassword: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret_diary)

        secretNumberPikerOne
        secretNumberPikerTwo
        secretNumberPikerThree
    }
}