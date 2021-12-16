package com.iwan.plasmahero_mobile.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.iwan.plasmahero_mobile.HomeActivity
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.posts.DonorPost
import com.iwan.plasmahero_mobile.data.source.remote.responses.DonorResponse
import com.iwan.plasmahero_mobile.utils.Helper
import com.iwan.plasmahero_mobile.utils.SessionManager
import com.iwan.plasmahero_mobile.utils.SessionManager.token
import com.iwan.plasmahero_mobile.utils.SessionManager.userId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*


class DonorFormFragment : Fragment() {
    lateinit var btnUploadPositive: Button
    lateinit var btnUploadNegative: Button

    lateinit var positiveEvidenceBase64: String
    lateinit var negativeEvidenceBase64: String

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donor_form, container, false)
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etAddress = view.findViewById<EditText>(R.id.etDonorAddress)
        val etCity = view.findViewById<EditText>(R.id.etDonorCity)
        val etAge = view.findViewById<EditText>(R.id.etDonorAge)
        val etPhone = view.findViewById<EditText>(R.id.etDonorPhone)
        val etWeight = view.findViewById<EditText>(R.id.etDonorWeight)
        val etNegativeDate = view.findViewById<EditText>(R.id.etDonorNegativeDate)
        val spinnerGender = view.findViewById<Spinner>(R.id.etDonorGender)
        val spinnerBloodType = view.findViewById<Spinner>(R.id.etDonorBloodType)
        val spinnerBloodRhesus = view.findViewById<Spinner>(R.id.etDonorBloodRhesus)
        val btnSubmit = view.findViewById<Button>(R.id.btnDonorFormSubmit)

        btnUploadPositive = view.findViewById<Button>(R.id.btnDonorPositiveEvidence)
        btnUploadNegative = view.findViewById<Button>(R.id.btnDonorNegativeEvidence)

        btnUploadNegative.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, PERMISSION_CODE)
                } else {
                    chooseImageGallery(NEGATIVE_IMAGE_CHOOSE)
                }
            } else {
                chooseImageGallery(NEGATIVE_IMAGE_CHOOSE)
            }
        }

        btnUploadPositive.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, PERMISSION_CODE)
                } else {
                    chooseImageGallery(POSITIVE_IMAGE_CHOOSE)
                }
            } else {
                chooseImageGallery(POSITIVE_IMAGE_CHOOSE)
            }
        }

        ArrayAdapter.createFromResource(
                requireContext(),
                R.array.gender,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerGender.adapter = adapter
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

        val calendar = Calendar.getInstance()
        val date = OnDateSetListener { view, year, monthOfYear, dayOfMonth -> // TODO Auto-generated method stub
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val myFormat = "MM/dd/yy" //In which you need put here

            val sdf = SimpleDateFormat(myFormat, Locale.US)

            etNegativeDate.setText(sdf.format(calendar.getTime()))
        }

        etNegativeDate.setOnClickListener(View.OnClickListener {
            // TODO Auto-generated method stub
            DatePickerDialog(requireContext(), date, calendar
                    .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show()
        })

        btnSubmit.setOnClickListener(View.OnClickListener {
            val prefs = SessionManager.getSharedPreferences(requireActivity())
            val token = "Bearer " + prefs.token
            val userId = prefs.userId

            val donorPost = DonorPost(
                    userId = userId,
                    address = etAddress.text.toString(),
                    city = etCity.text.toString(),
                    age = etAge.text.toString().toIntOrNull(),
                    phone = etPhone.text.toString(),
                    gender = spinnerBloodType.selectedItem.toString(),
                    bloodRhesus = spinnerBloodRhesus.selectedItem.toString(),
                    bloodType = spinnerBloodType.selectedItem.toString(),
                    weight = etWeight.text.toString().toIntOrNull(),
                    negativeTestDate = etNegativeDate.text.toString(),
                    negativeEvidence = negativeEvidenceBase64,
                    positiveEvidence = positiveEvidenceBase64,
            )
            Log.v("POST", "Create donor")
            Log.v("VAR: donorPost", donorPost.toString())

            val call = RemoteDataSource.createDonor(donorPost, token.toString())
            call.enqueue(object : Callback<DonorResponse> {
                override fun onResponse(call: Call<DonorResponse>, response: Response<DonorResponse>) {
                    if (response.body()?.success == true) {
                        Log.v("Response", response.body().toString())
                        Toast.makeText(requireContext(), "Create donor data success", Toast.LENGTH_SHORT).show()

                        activity?.setResult(Activity.RESULT_OK)

                        //Complete and destroy login activity once successful
                        activity?.finish()

                        val intent = Intent(activity, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Log.v("Response", response.body().toString())
                        Toast.makeText(requireContext(), "Create donor data failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<DonorResponse>, t: Throwable) {
                    Log.v("Response", "Created Donor Unsuccessfull")
                    Log.v("Response", t.message.toString())
                    Toast.makeText(requireContext(), "Create donor data failed", Toast.LENGTH_SHORT).show()
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
                    chooseImageGallery(NEGATIVE_IMAGE_CHOOSE)
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
        btnUploadNegative.text = picturePath

        val imageStream: InputStream? = context?.getContentResolver()?.openInputStream(imageUri!!)
        val selectedImage = BitmapFactory.decodeStream(imageStream)
        val encodedImage: String = "data:image/jpeg;base64," + Helper.encodeBitmapToBase64(selectedImage).toString()

        Log.v("BASE64 IMAGE", encodedImage)

        if (requestCode == NEGATIVE_IMAGE_CHOOSE && resultCode == Activity.RESULT_OK) {
            btnUploadNegative.text = picturePath
            negativeEvidenceBase64 =  encodedImage
        } else if (requestCode == POSITIVE_IMAGE_CHOOSE && resultCode == Activity.RESULT_OK) {
            btnUploadPositive.text = picturePath
            positiveEvidenceBase64 = encodedImage
        }
    }

    private fun chooseImageGallery(code: Int) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, code)
    }

    companion object {
        private val POSITIVE_IMAGE_CHOOSE = 1200;
        private val NEGATIVE_IMAGE_CHOOSE = 1201;
        private val PERMISSION_CODE = 1001;
    }
}