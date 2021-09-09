package com.reubencoutinho.newsapp.latestnews.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.reubencoutinho.newsapp.R
import com.reubencoutinho.newsapp.latestnews.model.model.Article
import kotlinx.android.synthetic.main.latest_news_item.view.*


class LatestNewsRecyclerAdapter(
    val arrayList: List<Article>,
    val context: Context
) : RecyclerView.Adapter<LatestNewsRecyclerAdapter.LatestNewsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): LatestNewsRecyclerAdapter.LatestNewsViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.latest_news_item, parent, false)
        return LatestNewsViewHolder(root)
    }

    override fun onBindViewHolder(holder: LatestNewsRecyclerAdapter.LatestNewsViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
//        if (arrayList.isEmpty()) {
//            Toast.makeText(context, "List is empty", Toast.LENGTH_LONG).show()
//        } else {
//
//        }
        return arrayList.size
    }


    inner class LatestNewsViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(article: Article) {
            binding.card_placeName.text = article.title
            binding.card_placeImageUrl.setImageURI()

        }

    }

}