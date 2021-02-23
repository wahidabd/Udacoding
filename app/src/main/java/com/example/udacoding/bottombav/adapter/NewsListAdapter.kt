package com.example.udacoding.bottombav.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.udacoding.R
import com.example.udacoding.bottombav.network.ArticlesItem
import kotlinx.android.synthetic.main.news_list.view.*

class NewsListAdapter(val list: List<ArticlesItem>) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]

        Glide.with(holder.itemView.context)
            .load(data.urlToImage)
            .into(holder.imgNew)

        holder.tvTitle.text = data.title
        holder.tvAuthor.text = data.source?.name
    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgNew = view.img_news
        var tvTitle = view.news_title
        var tvAuthor = view.news_desc
    }
}