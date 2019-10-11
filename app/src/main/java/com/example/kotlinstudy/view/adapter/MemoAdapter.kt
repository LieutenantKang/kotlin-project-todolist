package com.example.kotlinstudy.view.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.data.room.Memo

class MemoAdapter(val context: Context) : AdapterContract.View, AdapterContract.Model, RecyclerView.Adapter<MemoViewHolder>() {

    private lateinit var memoList : ArrayList<Memo>

    var onItemClickListener : OnItemClickListener? = null

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        memoList[position].let{
            holder.onBind(it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder =
            MemoViewHolder(context, parent, onItemClickListener)

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
}