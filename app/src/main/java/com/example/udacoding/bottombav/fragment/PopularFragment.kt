package com.example.udacoding.bottombav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.udacoding.R
import com.example.udacoding.bottombav.adapter.NewsListAdapter
import com.example.udacoding.bottombav.network.ArticlesItem
import com.example.udacoding.bottombav.presenter.PresenterPopuler
import kotlinx.android.synthetic.main.fragment_popular.*

class PopularFragment : Fragment(), PresenterPopuler.PopulerView {

    private var presenter: PresenterPopuler? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = PresenterPopuler(this)
        presenter?.getPopuler()

        rv_news.layoutManager = LinearLayoutManager(context)

    }

    override fun onSuccess(msg: String?, article: List<ArticlesItem?>?) {
        val adapter = NewsListAdapter(article as List<ArticlesItem>)
        rv_news.adapter = adapter
    }

    override fun onError(msg: String) {
        TODO("Not yet implemented")
    }
}