package com.iwan.plasmahero_mobile.ui.home

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.card.MaterialCardView
import com.iwan.plasmahero_mobile.LoginActivity
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.posts.DonorEvidencePost
import com.iwan.plasmahero_mobile.data.source.remote.responses.DonorEvidenceResponse
import com.iwan.plasmahero_mobile.data.source.remote.responses.ProfileResponse
import com.iwan.plasmahero_mobile.utils.Helper
import com.iwan.plasmahero_mobile.utils.SessionManager
import com.iwan.plasmahero_mobile.utils.SessionManager.token
import com.iwan.plasmahero_mobile.utils.SessionManager.userId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.InputStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvProfileName = view.findViewById<TextView>(R.id.tvProfileName)
        val tvProfileType = view.findViewById<TextView>(R.id.tvProfileType)
        val tvProfileDonorTotal = view.findViewById<TextView>(R.id.tvProfileDonorTotal)
        val tvProfileDonorLast = view.findViewById<TextView>(R.id.tvProfileDonorLast)
        val tvProfileDonorAgain = view.findViewById<TextView>(R.id.tvProfileDonorAgain)
        val tvStatusVerified = view.findViewById<TextView>(R.id.tvStatusVerified)
        val tvStatusUnverified = view.findViewById<TextView>(R.id.tvStatusUnverified)

        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val mcvHomeDonorHistory = view.findViewById<MaterialCardView>(R.id.mcvHomeDonorHistory)
        val mcvHomeAboutPlasma = view.findViewById<MaterialCardView>(R.id.mcvHomeAboutPlasma)
        val mcvHomeRecipientPoster = view.findViewById<MaterialCardView>(R.id.mcvHomeRecipientPoster)

        val llDonorInfo = view.findViewById<LinearLayout>(R.id.llDonorInfo)
        val btnUploadDonorEvidence = view.findViewById<Button>(R.id.btnUploadDonorEvidence)

        mcvHomeAboutPlasma.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_navigation_home_to_navigation_about_plasma)
        }

        mcvHomeDonorHistory.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_navigation_home_to_navigation_donor_history)
        }

        mcvHomeRecipientPoster.setOnClickListener{
            val navController = findNavController()
            navController.navigate(R.id.action_navigation_home_to_navigation_poster)
        }

        btnUploadDonorEvidence.setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, HomeFragment.PERMISSION_CODE)
                } else {
                    chooseImageGallery(HomeFragment.DONOR_EVIDENCE_CHOOSE)
                }
            } else {
                chooseImageGallery(HomeFragment.DONOR_EVIDENCE_CHOOSE)
            }
        }

        val prefs = SessionManager.getSharedPreferences(requireActivity())
        val token = "Bearer " + prefs.token
        val userId = prefs.userId
        val call = RemoteDataSource.getProfileById(userId, token.toString())
        call.enqueue(object : Callback<ProfileResponse> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(call: Call<ProfileResponse>, response: Response<ProfileResponse>) {
                Log.d("Response", response.toString())
                if (response.body()?.success == true) {
                    Log.v("Response success", response.body().toString())

                    tvProfileName.text = response.body()?.data?.name
                    if (response.body()?.data?.donor?.isValid == 1)
                        tvStatusVerified.visibility = View.VISIBLE
                    else
                        tvStatusUnverified.visibility = View.VISIBLE

                        if (response.body()?.data?.type == "donor") {
                            tvProfileType.text = getString(R.string.text_donor_role)
                            llDonorInfo.visibility = View.VISIBLE
                            btnUploadDonorEvidence.visibility = View.VISIBLE
                            mcvHomeDonorHistory.visibility = View.VISIBLE
                        } else {
                            tvProfileType.text = getString(R.string.text_recipient_role)
                            mcvHomeRecipientPoster.visibility = View.VISIBLE
                        }

                    val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

                    if (response.body()?.data?.history != null) {
                        tvProfileDonorTotal.text = response.body()?.data?.history!!.size.toString()
                        val donorDate = LocalDate.parse(response.body()?.data?.history!![0].donorDate, dateFormat)

                        tvProfileDonorLast.text = donorDate.dayOfMonth.toString() + " " + donorDate.month.toString() + " " + donorDate.year.toString();
                        tvProfileDonorAgain.text = donorDate.dayOfMonth.toString() + " " + (donorDate.month + 3).toString() + " " + donorDate.year.toString();
                    }
                } else {
                    Log.v("Response failed", response.body().toString())
                    Toast.makeText(requireContext(), "Gagal mendapat data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                Log.v("Response", "Get Profile Unsuccessfull")
                Log.v("Response", t.message.toString())
                Toast.makeText(requireContext(), "Terjadi error saat meminta data", Toast.LENGTH_SHORT).show()
            }
        })

        btnLogout.setOnClickListener {
            val prefs = SessionManager.getSharedPreferences(requireActivity())
            prefs.edit().clear().commit()

            requireActivity().setResult(Activity.RESULT_OK)
            requireActivity().finish()

            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showDonorEvidenceDialog(bitmapImage: Bitmap, encodedImage: String) {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.fragment_home_dialog_upload)
        val etUdd = dialog.findViewById<EditText>(R.id.etDialogUdd)
        val btnUpload = dialog.findViewById<Button>(R.id.btnDialogUpload)
        val ivDonorEvidence = dialog.findViewById<ImageView>(R.id.ivDialogDonorEvidence)

        btnUpload.setOnClickListener {
            val prefs = SessionManager.getSharedPreferences(requireActivity())
            val token = "Bearer " + prefs.token
            val userId = prefs.userId

            val donorEvidencePost = DonorEvidencePost(userId, etUdd.text.toString(), encodedImage)

            val call = RemoteDataSource.createDonorHistory(donorEvidencePost, token.toString())
            call.enqueue(object : Callback<DonorEvidenceResponse> {
                @RequiresApi(Build.VERSION_CODES.O)
                override fun onResponse(call: Call<DonorEvidenceResponse>, response: Response<DonorEvidenceResponse>) {
                    Log.d("Response", response.toString())
                    if (response.body()?.success == true) {
                        Log.v("Response success", response.body().toString())
                        Toast.makeText(requireContext(), "Update data donor berhasil", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.v("Response failed", response.body().toString())
                        Toast.makeText(requireContext(), "Gagal mendapat data", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<DonorEvidenceResponse>, t: Throwable) {
                    Log.v("Response", "Get Profile Unsuccessfull")
                    Log.v("Response", t.message.toString())
                    Toast.makeText(requireContext(), "Terjadi error saat meminta data", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.dismiss()
        }
        dialog.show()

//        ivDonorEvidence.setImageBitmap(bitmapImage)
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        when (requestCode) {
            HomeFragment.PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    chooseImageGallery(HomeFragment.DONOR_EVIDENCE_CHOOSE)
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

        val imageStream: InputStream? = context?.getContentResolver()?.openInputStream(imageUri!!)
        val selectedImage = BitmapFactory.decodeStream(imageStream)
        val encodedImage: String = "data:image/jpeg;base64," + Helper.encodeBitmapToBase64(selectedImage).toString()

        Log.v("BASE64 IMAGE", encodedImage)

        showDonorEvidenceDialog(selectedImage, encodedImage)
    }

    private fun chooseImageGallery(code: Int) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, code)
    }

    companion object {
        private val DONOR_EVIDENCE_CHOOSE = 1204;
        private val PERMISSION_CODE = 1001;
    }
}