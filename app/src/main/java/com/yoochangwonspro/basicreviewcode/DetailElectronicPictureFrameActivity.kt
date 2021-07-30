package com.yoochangwonspro.basicreviewcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DetailElectronicPictureFrameActivity : AppCompatActivity() {

    private val electronicBackGroundImageView: ImageView by lazy {
        findViewById(R.id.electronic_picture_background_image_view)
    }

    private val electronicPictureImageView: ImageView by lazy {
        findViewById(R.id.electronic_picture_image_view)
    }

    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dtail_electronic_picture_frame)
    }
}