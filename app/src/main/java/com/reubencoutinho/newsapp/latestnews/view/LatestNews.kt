package com.reubencoutinho.newsapp.latestnews.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reubencoutinho.newsapp.databinding.FragmentLatestNewsBinding
import com.reubencoutinho.newsapp.latestnews.viewmodel.LatestNewsViewModel
import kotlinx.android.synthetic.main.fragment_latest_news.*


class LatestNews : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var binding: FragmentLatestNewsBinding
    private val latestNewsViewModel: LatestNewsViewModel by activityViewModels()
    private var viewManager = LinearLayoutManager(this.context)
    private lateinit var latestNewsRecycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLatestNewsBinding.inflate(layoutInflater)
        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        latestNewsRecycler = recyclerForLatestNewsView
        latestNewsViewModel.fetchData()
        latestNewsRecycler.layoutManager = LinearLayoutManager(this.context)


//
//        buttonFetchData.setOnClickListener {
//            latestNewsViewModel.fetchData()
//        }



        latestNewsViewModel.latestNewsLiveData.observe(viewLifecycleOwner, Observer { latestNewsModel->
//            Log.d("TAG", latestNewsModel.articles[0].author)
            latestNewsRecycler.adapter= this.context?.let {
                LatestNewsRecyclerAdapter( latestNewsModel.articles,
                    it
                )
            }
        })
    }




}