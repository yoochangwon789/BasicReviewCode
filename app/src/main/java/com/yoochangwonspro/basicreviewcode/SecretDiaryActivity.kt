package com.yoochangwonspro.basicreviewcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_secret_diary.*

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

    private fun initSecretOpenButton() {
        secret_open_btn.setOnClickListener {
            if (secretCheckPassword) {
                // 다이어리 페이지로 이동
            } else {
                // 패스워드 불일치일 경우 다이로그 창 띄우기
            }
        }
    }

    private fun falsePasswordPopUp() {
        AlertDialog.Builder(this)
            .setTitle("실패!!")
            .setMessage("비밀번호가 틀렸습니다.")
            .setPositiveButton("확인") { _, _ -> }
            .create()
            .show()
    }
}