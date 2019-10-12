package com.example.kotlinstudy.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.Contract.AdapterContract
import com.example.kotlinstudy.R
import com.example.kotlinstudy.Room.Memo
import kotlinx.android.synthetic.main.item_memo.view.*

class MemoAdapter(val context: Context) : AdapterContract.View, AdapterContract.Model, RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    private lateinit var memoList : ArrayList<Memo>

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        memoList[position].let{ item ->
            with(holder) {
                tvTitle.text = item.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(view)
    }


    override fun getItemCount() = memoList.size

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun addItems(memos: ArrayList<Memo>) {
        this.memoList = memos
    }

    override fun clearItem() {
        memoList.clear()
    }

    inner class MemoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.item_memo_title
    }
}