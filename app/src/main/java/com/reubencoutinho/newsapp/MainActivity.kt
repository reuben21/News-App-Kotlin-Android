package com.reubencoutinho.newsapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.reubencoutinho.newsapp.country.view.CountryFragment
import com.reubencoutinho.newsapp.home.view.HomeFragment
import com.reubencoutinho.newsapp.latestnews.view.LatestNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val latestFragment = LatestNews()
    private val countryFragment = CountryFragment()
    private val homeFragment = HomeFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        bottom_navigation?.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.ic_news_home -> replaceFragment(homeFragment)
                R.id.id_latest_news -> replaceFragment(latestFragment)
                R.id.id_news_country -> replaceFragment(countryFragment)
            }
            true

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