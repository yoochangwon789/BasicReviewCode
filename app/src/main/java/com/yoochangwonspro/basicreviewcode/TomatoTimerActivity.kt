package com.yoochangwonspro.basicreviewcode

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.SeekBar
import android.widget.TextView

class TomatoTimerActivity : AppCompatActivity() {

    private val minTextView: TextView by lazy {
        findViewById(R.id.pomodoro_min_text_view)
    }

    private val secondTextView: TextView by lazy {
        findViewById(R.id.pomodoro_second_text_view)
    }

    private val seekBar: SeekBar by lazy {
        findViewById(R.id.pomodoro_seek_bar)
    }

    private var currentPositionTimer: CountDownTimer? = null

    private val soundPool: SoundPool = SoundPool.Builder().build()
    private var tickBellSoundPool: SoundPool? = null
    private var bellSoundPool: SoundPool? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tomato_timer)
    }


}