package com.yoochangwonspro.basicreviewcode

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_detail_diary.*

class DetailDiaryActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_diary)

        val diarySharedPreference = getSharedPreferences("diary", Context.MODE_PRIVATE)
        detail_diary_edit_text.setText(diarySharedPreference.getString("diary", ""))

        val runnable = Runnable {
            diarySharedPreference.edit {
                putString("diary", detail_diary_edit_text.text.toString())
            }
        }

        detail_diary_edit_text.addTextChangedListener {
            handler.removeCallbacks(runnable)
            handler.postDelayed(runnable, 500)
        }
    }
}