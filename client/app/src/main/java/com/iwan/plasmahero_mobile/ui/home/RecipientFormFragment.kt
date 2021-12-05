package com.iwan.plasmahero_mobile.ui.home

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.iwan.plasmahero_mobile.HomeActivity
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.posts.RecipientPost
import com.iwan.plasmahero_mobile.data.source.remote.responses.DonorResponse
import com.iwan.plasmahero_mobile.data.source.remote.responses.RecipientResponse
import com.iwan.plasmahero_mobile.utils.Helper
import com.iwan.plasmahero_mobile.utils.SessionManager
import com.iwan.plasmahero_mobile.utils.SessionManager.token
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*

class RecipientFormFragment : Fragment() {
    lateinit var btnHospitalLetter: Button
    lateinit var hospitalLetterBase64: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipient_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etHospitalName = view.findViewById<EditText>(R.id.etRecipientHospitalName)
        val etHospitalCity = view.findViewById<EditText>(R.id.etRecipientHospitalCity)
        val etPhone = view.findViewById<EditText>(R.id.etRecipientPhone)
        val spinnerBloodType = view.findViewById<Spinner>(R.id.etRecipientBloodType)
        val spinnerBloodRhesus = view.findViewById<Spinner>(R.id.etRecipientBloodRhesus)
        val btnSubmit = view.findViewById<Button>(R.id.btnRecipientFormSubmit)

        btnHospitalLetter = view.findViewById<Button>(R.id.btnRecipientHospitalLetter)

        btnHospitalLetter.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, PERMISSION_CODE)
                } else {
                    chooseImageGallery(HOSPITAL_LETTER_CHOOSE)
                }
            } else {
                chooseImageGallery(HOSPITAL_LETTER_CHOOSE)
            }
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.blood_type,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerBloodType.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.blood_rhesus,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerBloodRhesus.adapter = adapter
        }

        btnSubmit.setOnClickListener(View.OnClickListener {
            val recipientPost = RecipientPost(
                userId = 1,
                phone = etPhone.text.toString(),
                bloodRhesus = spinnerBloodRhesus.selectedItem.toString(),
                bloodType = spinnerBloodType.selectedItem.toString(),
                hospitalName = etHospitalName.text.toString(),
                hospitalCity = etHospitalCity.text.toString(),
                hospital_letter = hospitalLetterBase64,
            )
            Log.v("POST", "Create recipient")
            Log.v("VAR: recipientPost", recipientPost.toString())

            val prefs = SessionManager.getSharedPreferences(requireActivity())
            val token = "Bearer " + prefs.token
            val call = RemoteDataSource.createRecipient(recipientPost, token.toString())
            call.enqueue(object : Callback<RecipientResponse> {
                override fun onResponse(call: Call<RecipientResponse>, response: Response<RecipientResponse>) {
                    Log.d("Response", response.toString())
                    if (response.body()?.success == true) {
                        Log.v("Response success", response.body().toString())
                        Toast.makeText(requireContext(), "Berhasil menyimpan data", Toast.LENGTH_SHORT).show()

                        activity?.setResult(Activity.RESULT_OK)

                        //Complete and destroy login activity once successful
                        activity?.finish()

                        val intent = Intent(activity, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Log.v("Response failed", response.body().toString())
                        Toast.makeText(requireContext(), "Gagal menyimpan data", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<RecipientResponse>, t: Throwable) {
                    Log.v("Response", "Created Recipient Unsuccessfull")
                    Log.v("Response", t.message.toString())
                    Toast.makeText(requireContext(), "Terjadi error saat mengupload data", Toast.LENGTH_SHORT).show()
                }
            })
        })
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    chooseImageGallery(HOSPITAL_LETTER_CHOOSE)
                } else {
                    Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val imageUri = data?.data
        val picturePath = Helper.getPathFromUri(requireActivity().applicationContext, imageUri)
        btnHospitalLetter.text = picturePath

        val imageStream: InputStream? = context?.getContentResolver()?.openInputStream(imageUri!!)
        val selectedImage = BitmapFactory.decodeStream(imageStream)
        val encodedImage: String = "data:image/jpeg;base64," + Helper.encodeBitmapToBase64(selectedImage).toString()

        Log.v("BASE64 IMAGE", encodedImage)

        if (requestCode == HOSPITAL_LETTER_CHOOSE && resultCode == Activity.RESULT_OK) {
            btnHospitalLetter.text = picturePath
            hospitalLetterBase64 =  encodedImage
        }
    }

    private fun chooseImageGallery(code: Int) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, code)
    }

    companion object {
        private val HOSPITAL_LETTER_CHOOSE = 1200;
        private val PERMISSION_CODE = 1001;
    }
}