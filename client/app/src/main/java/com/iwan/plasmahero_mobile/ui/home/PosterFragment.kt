package com.iwan.plasmahero_mobile.ui.home

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.responses.PosterResponse
import com.iwan.plasmahero_mobile.utils.SessionManager
import com.iwan.plasmahero_mobile.utils.SessionManager.token
import com.iwan.plasmahero_mobile.utils.SessionManager.userId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream


class PosterFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poster, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivPoster = view.findViewById<ImageView>(R.id.ivPoster)
        val btnShare = view.findViewById<Button>(R.id.btnPosterShare)

        btnShare.setOnClickListener{
            val bitmap = ivPoster.drawable.toBitmap()
            shareImageandText(bitmap)
        }

        val prefs = SessionManager.getSharedPreferences(requireActivity())
        val token = "Bearer " + prefs.token
        val userId = prefs.userId
        val call = RemoteDataSource.getPosterById(userId, token.toString())
        call.enqueue(object : Callback<PosterResponse> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(call: Call<PosterResponse>, response: Response<PosterResponse>) {
                Log.d("Response", response.toString())
                if (response.body()?.success == true) {
                    Log.v("Response success", response.body().toString())
                    Glide.with(requireActivity()).load(response.body()!!.data?.posterUrl).into(ivPoster)
                } else {
                    Log.v("Response failed", response.body().toString())
                    Toast.makeText(requireContext(), "Gagal mendapat data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<PosterResponse>, t: Throwable) {
                Log.v("Response", "Get Poster Unsuccessfull")
                Log.v("Response", t.message.toString())
                Toast.makeText(requireContext(), "Terjadi error saat meminta data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun shareImageandText(bitmap: Bitmap) {
        val uri: Uri? = getmageToShare(bitmap)
        val intent = Intent(Intent.ACTION_SEND)

        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.putExtra(Intent.EXTRA_TEXT, "Sharing Image")
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
        intent.type = "image/png"

        // calling startactivity() to share
        startActivity(Intent.createChooser(intent, "Share Via"))
    }

    // Retrieving the url to share
    private fun getmageToShare(bitmap: Bitmap): Uri? {
        val imagefolder = File(requireActivity().getCacheDir(), "images")
        var uri: Uri? = null
        try {
            imagefolder.mkdirs()
            val file = File(imagefolder, "shared_image.png")
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, outputStream)
            outputStream.flush()
            outputStream.close()
            uri = FileProvider.getUriForFile(requireContext(), "com.iwan.plasmahero_mobile.fileprovider", file)
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "" + e.message, Toast.LENGTH_LONG).show()
        }
        return uri
    }
}