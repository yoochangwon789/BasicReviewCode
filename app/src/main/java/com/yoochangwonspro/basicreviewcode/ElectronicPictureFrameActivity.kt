package com.yoochangwonspro.basicreviewcode

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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

    private val pictureUriList: MutableList<Uri> = mutableListOf()

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
                    navigateImage()
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
        pictureElectronicPictureFrameButton.setOnClickListener {
            if (pictureUriList.isEmpty()) {
                Toast.makeText(this, "????????? ????????? ????????????.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, DetailElectronicPictureFrameActivity::class.java)
            val pictureUriListSize = pictureUriList.size
            intent.putExtra("pictureUriListSize", pictureUriListSize)
            pictureUriList.forEachIndexed { index, uri ->
                intent.putExtra("photo$index", uri.toString())
            }
            startActivity(intent)
        }
    }

    private fun navigateImage() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForResult.launch(intent)
    }

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->

        if (result.resultCode != Activity.RESULT_OK) {
            Toast.makeText(this, "????????? ???????????? ???????????????.", Toast.LENGTH_SHORT).show()
            return@registerForActivityResult
        }
        else {
            val intent = result.data
            val selectedUri: Uri? = intent?.data

            if (selectedUri != null) {
                pictureUriList.add(selectedUri)
                pictureFrameImageViewList[pictureUriList.size - 1]
                    .setImageURI(selectedUri)

                if (pictureUriList.size == 6) {
                    Toast.makeText(this, "????????? ?????? ????????????.", Toast.LENGTH_SHORT).show()
                    return@registerForActivityResult
                }
            }
            else {
                Toast.makeText(this, "????????? ???????????? ???????????????.", Toast.LENGTH_SHORT).show()
                return@registerForActivityResult
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            1000 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    navigateImage()
                }
                else {
                    Toast.makeText(this, "????????? ?????????????????????.",Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                //
            }
        }
    }

    private fun showPermissionContextPotUp() {
        AlertDialog.Builder(this)
            .setTitle("????????? ???????????????")
            .setMessage("?????? ?????? ????????? ????????? ???????????? ?????? ????????? ???????????????.")
            .setPositiveButton("????????????") { _, _ ->
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
            }
            .setNegativeButton("????????????") { _, _ -> }
            .create()
            .show()
    }
}