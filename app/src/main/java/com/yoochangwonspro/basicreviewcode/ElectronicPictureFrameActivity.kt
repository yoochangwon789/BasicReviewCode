package com.yoochangwonspro.basicreviewcode

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ElectronicPictureFrameActivity : AppCompatActivity() {

    private val pictureAddButton: Button by lazy {
        findViewById(R.id.picture_frame_add_btn)
    }

    private val pictureElectronicPictureFrame: Button by lazy {
        findViewById(R.id.picture_frame_start_frame)
    }

    private val pictureFrameImageViewList: List<ImageView> by lazy {
        mutableListOf<ImageView>().apply {
            add(findViewById(R.id.picture_frame_image_one_one))
            add(findViewById(R.id.picture_frame_image_one_two))
            add(findViewById(R.id.picture_frame_image_one_three))
            add(findViewById(R.id.picture_frame_image_two_one))
            add(findViewById(R.id.picture_frame_image_two_two))
            add(findViewById(R.id.picture_frame_image_two_three))
        }
    }

    private val pictureUriList: List<Uri> by lazy {
        mutableListOf<Uri>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronic_picture_frame)
    }
}