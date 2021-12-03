package com.iwan.plasmahero_mobile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setResult(Activity.RESULT_OK)

        //Complete and destroy login activity once successful
        finish()

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}