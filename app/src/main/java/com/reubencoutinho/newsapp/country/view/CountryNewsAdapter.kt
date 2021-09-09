package com.reubencoutinho.newsapp.country.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.reubencoutinho.newsapp.R
import com.reubencoutinho.newsapp.country.model.model.Article
import kotlinx.android.synthetic.main.latest_news_item.view.*

internal class CountryNewsAdapter(
    private val context: Context,
    private val article: List<Article>,
) :
    BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    override fun getCount(): Int {
        return article.size
    }
    override fun getItem(position: Int): Any? {
        return null
    }
    override fun getItemId(position: Int): Long {
        return 0
    }
    override fun getView(
        position: Int,
        binding: View?,
        parent: ViewGroup
    ): View? {
        var convertView = binding
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.news_row_item, null)
        }
        imageView = convertView!!.findViewById(R.id.card_placeImageUrl_country)
        textView = convertView.findViewById(R.id.card_placeName_country)

        if (binding != null) {
            Glide.with(binding).load(article[position].urlToImage).into(imageView)
        }

        textView.text = article[position].title
        return convertView
    }
}