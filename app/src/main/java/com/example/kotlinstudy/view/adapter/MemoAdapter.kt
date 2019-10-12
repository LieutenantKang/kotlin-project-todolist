package com.example.kotlinstudy.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.R
import com.example.kotlinstudy.data.room.Memo
import kotlinx.android.synthetic.main.item_memo.view.*

class MemoAdapter(private var memoList : ArrayList<Memo>) : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = memoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        memoList[position].let{ item ->
            with(holder) {
                textView.text = item.title
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.item_memo_title
    }
}