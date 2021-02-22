package com.example.udacoding.recyclerview.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.udacoding.R
import kotlinx.android.synthetic.main.item_list.view.*

class ListHeroAdapter(val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
        }
    }

    inner class ListViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvName = v.tv_name
        var tvDetail = v.tv_detail
        var imgPhoto = v.img_profile
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Hero)
    }
}