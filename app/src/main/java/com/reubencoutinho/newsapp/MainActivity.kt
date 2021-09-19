package com.reubencoutinho.newsapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

import com.reubencoutinho.newsapp.country.view.CountryFragment
import com.reubencoutinho.newsapp.latestnews.view.LatestNews
import com.reubencoutinho.newsapp.sawolabs.SawoLabsAuth
import kotlinx.android.synthetic.main.activity_main.*
import com.sawolabs.androidsdk.LOGIN_SUCCESS_MESSAGE

class MainActivity : AppCompatActivity() {

    private val latestFragment = LatestNews()
    private val countryFragment = CountryFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val message = intent.getStringExtra(LOGIN_SUCCESS_MESSAGE)
        if (message != null) {
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
            replaceFragment(latestFragment)
            bottom_navigation?.setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.id_latest_news -> replaceFragment(latestFragment)
                    R.id.id_news_country -> replaceFragment(countryFragment)
                }
                true

            }
        } else {
            MaterialAlertDialogBuilder(this,
                R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog_FullWidthButtons)
                .setMessage("AUTHENTICATION FAILED")
                .setPositiveButton("ACCEPT") { dialog, which ->
                    // Respond to positive button press
                    val intent = Intent(applicationContext, SawoLabsAuth::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                }
                .show()
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }

    override fun onStart() {
        super.onStart()

        Log.d("TAG", "onStart: called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: called")

    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause: called")

    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop: called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy: called")

    }
}