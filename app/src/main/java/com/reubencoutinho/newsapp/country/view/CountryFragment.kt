package com.reubencoutinho.newsapp.country.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.reubencoutinho.newsapp.R
import com.reubencoutinho.newsapp.country.viewmodel.CountryViewModel
import com.reubencoutinho.newsapp.databinding.FragmentCountryBinding
import com.reubencoutinho.newsapp.latestnews.view.LatestNewsRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {

    lateinit var binding: FragmentCountryBinding
    private val countryViewModel: CountryViewModel by activityViewModels()

    lateinit var gridView: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCountryBinding.inflate(layoutInflater)
        return binding.root
//        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val country = "us"

        countryViewModel.fetchData()
        gridView = gridViewCountryNews


        countryViewModel.countryNewsLiveData.observe(viewLifecycleOwner, Observer { countryNewsModel ->
//            Log.d("TAG", latestNewsModel.articles[0].author)

            val countryNewsAdapter = this.context?.let { CountryNewsAdapter(it,countryNewsModel.articles) }
            gridView.adapter= countryNewsAdapter
//            gridView.onItemClickListener = AdapterView.OnItemClickListener { _, binding:View, position, _ ->
//                Log.d("TAG", "latestNewsModel.articles[0].author")
//                this.context?.let {
//                    MaterialAlertDialogBuilder(it)
//                        .setTitle(
//                            countryNewsModel.articles[position
//                            ].title
//                        )
////                        .setMessage(resources.getString(R.string.supporting_text))
//                        .show()
//                }
//            }
        })


    }


//        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
//
//            this.context?.let {
//                MaterialAlertDialogBuilder(it)
//                    .setTitle(resources.getString())
//                    .setMessage(resources.getString(R.string.supporting_text))
////                    .setNeutralButton(resources.getString(R.string.cancel)) { dialog, which ->
////                        // Respond to neutral button press
////                    }
////                    .setNegativeButton(resources.getString(R.string.decline)) { dialog, which ->
////                        // Respond to negative button press
////                    }
////                    .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
////                        // Respond to positive button press
////                    }
//                    .show()
//            }
//        }
//    }


}