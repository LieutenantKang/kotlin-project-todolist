package com.example.kotlinstudy.view.activity.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.view.adapter.MemoAdapter

import com.example.kotlinstudy.R
import com.example.kotlinstudy.base.BaseActivity
import com.example.kotlinstudy.view.activity.write.WriteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View {
    override val layoutRes: Int
        get() = R.layout.activity_main

    private val memoAdapter: MemoAdapter by lazy { MemoAdapter(this) }

    override fun initView() {
        presenter = MainPresenter(this)

        presenter.start()
        presenter.loadMemos(false)
    }

    override fun onClickEvent() {
        super.onClickEvent()

        main_create_button.setOnClickListener {
            startActivity(Intent(this@MainActivity, WriteActivity::class.java))
        }

        main_delete_button.setOnClickListener {

        }
    }

    // region mvp
    override lateinit var presenter: MainContract.Presenter

    override fun isViewActive(): Boolean = checkActive()

    override fun setRecyclerView() {
        main_recycler_view.apply {
            this.adapter = memoAdapter
            this.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
// endregion
}
