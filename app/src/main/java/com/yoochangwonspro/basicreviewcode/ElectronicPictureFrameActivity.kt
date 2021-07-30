package com.yoochangwonspro.basicreviewcode

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat

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

        initPictureAddButton()
        initPictureElectronicPictureFrame()
    }

    private fun initPictureAddButton() {
        pictureAddButton.setOnClickListener {
            when {
                ContextCompat.checkSelfPermission(
                    this, android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {

                }

                shouldShowRequestPermissionRationale(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) -> {
                    showPermissionContextPotUp()
                }

                else -> {
                    requestPermissions(
                        arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                        1000
                    )
                }
            }
        }
    }

    private fun initPictureElectronicPictureFrame() {

    }

    private fun showPermissionContextPotUp() {

    }
}