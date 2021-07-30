package com.yoochangwonspro.basicreviewcode

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dtail_electronic_picture_frame)

        val pictureUriSize = intent.getIntExtra("pictureUriListSize", 0)
        for (i in 0 until pictureUriSize) {
            val pictureUri = intent.getStringExtra("photo$i")
            pictureUriList.add(Uri.parse(pictureUri))
        }
    }

    fun startTimer() {
        timer(period = 5000) {
            runOnUiThread {

            }
        }
    }
}