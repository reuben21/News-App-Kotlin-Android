package com.reubencoutinho.newsapp.profile.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reubencoutinho.newsapp.R
import com.sawolabs.androidsdk.LOGIN_SUCCESS_MESSAGE
import android.content.Intent.getIntent

import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.fragment_profile.*
import org.json.JSONObject


class Profile : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = requireArguments().getString("message")
        var obj = JSONObject(data.toString())
        var nestedObject = JSONObject(obj["customFieldInputValues"].toString())
        Log.d("MESSAGE",obj["user_id"].toString())

        displayEmailId.text = obj["identifier"].toString()
        displayFirstName.text = nestedObject["First Name"].toString()
        displayLastName.text = nestedObject["Last Name"].toString()

    }


}