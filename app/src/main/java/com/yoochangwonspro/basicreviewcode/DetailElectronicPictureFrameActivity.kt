package com.yoochangwonspro.basicreviewcode

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import java.util.*
import kotlin.concurrent.timer

class DetailElectronicPictureFrameActivity : AppCompatActivity() {

    private val electronicBackGroundImageView: ImageView by lazy {
        findViewById(R.id.electronic_picture_background_image_view)
    }

    private val electronicPictureImageView: ImageView by lazy {
        findViewById(R.id.electronic_picture_image_view)
    }

    private val pictureUriList = mutableListOf<Uri>()

    private var currentPosition = 0

    private var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dtail_electronic_picture_frame)

        pictureGetUri()
    }

    fun pictureGetUri() {
        val pictureUriSize = intent.getIntExtra("pictureUriListSize", 0)
        for (i in 0 until pictureUriSize) {
            intent.getStringExtra("photo$i")?.let {
                pictureUriList.add(Uri.parse(it))
            }
        }
    }

    fun startTimer() {
        timer = timer(period = 5000) {
            runOnUiThread {
                val current = currentPosition
                val next = if (pictureUriList.size - 1 <= currentPosition) 0 else currentPosition + 1

                electronicBackGroundImageView.setImageURI(pictureUriList[current])

                electronicPictureImageView.alpha = 0f

                electronicPictureImageView.animate()
                    .alpha(1.0f)
                    .setDuration(1000)
                    .start()

                currentPosition = next
            }
        }
    }
}