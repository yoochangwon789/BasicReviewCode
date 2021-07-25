package com.yoochangwonspro.basicreviewcode

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_secret_diary.*

class SecretDiaryActivity : AppCompatActivity() {

    private val secretNumberPikerOne: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.secret_number_picker_one)
            .apply {
                this.minValue = 0
                this.maxValue = 9
            }
    }

    private val secretNumberPikerTwo: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.secret_number_picker_two)
            .apply {
                this.minValue = 0
                this.maxValue = 9
            }
    }

    private val secretNumberPikerThree: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.secret_number_picker_three)
            .apply {
                this.minValue = 0
                this.maxValue = 9
            }
    }

    private var secretCheckPassword: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret_diary)

        secretNumberPikerOne
        secretNumberPikerTwo
        secretNumberPikerThree

        initSecretOpenButton()
        initSecretChangePasswordButton()
    }

    private fun initSecretOpenButton() {
        secret_open_btn.setOnClickListener {
            val sp = getSharedPreferences("password", Context.MODE_PRIVATE)

            if (sp.getString("password", "000").equals("${secretNumberPikerOne.value}" +
                        "${secretNumberPikerTwo.value}${secretNumberPikerThree.value}")) {
                // 성공시 다이러리 창으로 이동
            } else {
                falsePasswordPopUp()
            }
        }
    }

    private fun initSecretChangePasswordButton() {
        val sp = getSharedPreferences("password", Context.MODE_PRIVATE)
        val password = "${secretNumberPikerOne.value}" +
                "${secretNumberPikerTwo.value}${secretNumberPikerThree.value}"

        secret_password_change.setOnClickListener {

            if (secretCheckPassword) {
                sp.edit(true) {
                    putString("password", password)
                }

                secretCheckPassword = false
                secret_password_change.setBackgroundColor(Color.BLACK)
            }
            else {

                if (sp.getString("password", "000").equals(password)) {

                    secretCheckPassword = true
                    Toast.makeText(this, "변경할 패스워드를 입력해주세요.", Toast.LENGTH_LONG).show()
                    secret_password_change.setBackgroundColor(Color.RED)
                }
                else falsePasswordPopUp()
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