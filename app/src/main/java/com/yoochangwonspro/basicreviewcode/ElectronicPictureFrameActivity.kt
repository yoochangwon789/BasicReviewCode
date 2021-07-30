package com.yoochangwonspro.basicreviewcode

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class ElectronicPictureFrameActivity : AppCompatActivity() {

    private val pictureAddButton: Button by lazy {
        findViewById(R.id.picture_frame_add_btn)
    }

    private val pictureElectronicPictureFrameButton: Button by lazy {
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
        pic
    }

    private fun showPermissionContextPotUp() {
        AlertDialog.Builder(this)
            .setTitle("권한이 필요합니다")
            .setMessage("전자 액자 앱에서 사진을 불러오기 위해 권한이 필요합니다.")
            .setPositiveButton("동의하기") { _, _ ->
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
            }
            .setNegativeButton("취소하기") { _, _ -> }
            .create()
            .show()
    }
}