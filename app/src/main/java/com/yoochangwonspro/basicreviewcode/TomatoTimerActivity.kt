package com.yoochangwonspro.basicreviewcode

import android.annotation.SuppressLint
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
    private var tickBellSoundPoolId: Int? = null
    private var bellSoundPoolId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tomato_timer)

        initSeekBar()
    }

    private fun initSeekBar() {
        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {

                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            }
        )
    }

    private fun createCountDownTimer(millionSeconds: Long) =
        object : CountDownTimer(millionSeconds, 1L) {

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

            }
        }

    private fun startCountDownTimer() {
        currentPositionTimer = createCountDownTimer(seekBar.progress * 60 * 1000L).start()
        currentPositionTimer = null

        tickBellSoundPoolId?.let {
            soundPool.play(it, 1F, 1F, 0, -1, 1F)
        }
    }

    private fun completeCountDownTimer() {
        updateSeekBar(0)
        updateSeekBar(0)

        soundPool.autoPause()
        bellSoundPoolId?.let {
            soundPool.play(it, 1F, 1F, 0, -1, 1F)
        }
    }

    private fun initSound() {
        tickBellSoundPoolId = soundPool.load(this, R.raw.timer_ticking, 0)
        bellSoundPoolId = soundPool.load(this, R.raw.timer_bell, 0)
    }

    @SuppressLint("SetTextI18n")
    private fun updateDownTimer(millionSeconds: Long) {
        val remainMillionSeconds = millionSeconds / 1000

        minTextView.text = "%02d'".format(remainMillionSeconds / 60)
        secondTextView.text = "%02d".format(remainMillionSeconds % 60)
    }

    private fun updateSeekBar(millionSeconds: Long) {
        seekBar.progress = (millionSeconds / 1000 / 60).toInt()
    }
}