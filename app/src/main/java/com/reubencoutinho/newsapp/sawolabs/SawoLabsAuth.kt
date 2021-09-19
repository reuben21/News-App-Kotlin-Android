package com.reubencoutinho.newsapp.sawolabs

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import com.reubencoutinho.newsapp.MainActivity
import com.reubencoutinho.newsapp.R
import com.sawolabs.androidsdk.Sawo

import kotlinx.android.synthetic.main.activity_sawo_labs_auth.*

class SawoLabsAuth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sawo_labs_auth)
        try {
            // TODO :- To Hide the Toolbar which Comes by Default
            this.supportActionBar!!.hide()
        }
        catch (e: NullPointerException) {
        }

        // TODO :- To Make Fragment Visible in Full Screen
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        sawoAuthButton.setOnClickListener {
            Sawo(
                this,
                "fa085b4a-0d04-4a16-9ecc-3177770a4fc4", // your api key
                "6146bdd235bc1e036361243fjDJ5TTwjzcG1a0hsT2nBBs7l"  // your api key secret
            ).login(
                "phone_number_sms", // can be one of 'email' or 'phone_number_sms'
                MainActivity::class.java.name // Callback class name
            )
        }
    }
}
