package ru.student.assistant.auth.ui

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import ru.student.assistant.auth.R

class AuthConnectionFragment : Fragment() {

    private val imageView: AppCompatImageView? = null
    private var filePath: Uri? = null

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)
        return inflater.inflate(R.layout.fr_connection, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //choseImage()
    }


    private fun choseImage() {
        val intent = Intent().apply {
            type = "image/*"
            action = Intent.ACTION_GET_CONTENT
        }

        startActivityForResult(Intent.createChooser(intent, "SelectImage"), PICK_IMAGE_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
            && data != null && data.data != null
        ) {

            filePath = data.data

          /*  try {

                val bitmap: Bitmap = if (android.os.Build.VERSION.SDK_INT >= 29) {

                    ImageDecoder.decodeBitmap(ImageDecoder.createSource(filePath))
                } else {

                    MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
                }
                // imageView.setImageBitmap(bitmap);

            } catch (e: IOException) {
                e.printStackTrace()
            }*/


        }
    }

    private companion object {
        private const val PICK_IMAGE_REQUEST = 71
    }

}