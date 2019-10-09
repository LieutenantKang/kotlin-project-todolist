package com.example.kotlinstudy.View

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.Adapter.MemoAdapter
import com.example.kotlinstudy.Contract.MainContract
import com.example.kotlinstudy.Model.MemoModel
import com.example.kotlinstudy.Presenter.MainPresenter

import com.example.kotlinstudy.R

class MainActivity : BaseActivity(), MainContract.View, View.OnClickListener {

    private val recyclerView by lazy {
        findViewById(R.id.main_recycler_view) as RecyclerView
    }

    private lateinit var memoAdapter : MemoAdapter

    private lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        memoAdapter = MemoAdapter(this)
        recyclerView.adapter = memoAdapter

        presenter=MainPresenter(this@MainActivity, applicationContext).apply {
            view=this@MainActivity
            adapterModel=memoAdapter
            adapterView=memoAdapter
        }

        presenter.loadMemos(this, false)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.main_create_button -> {

            }
            R.id.main_delete_button -> {

            }
        }
    }
}
