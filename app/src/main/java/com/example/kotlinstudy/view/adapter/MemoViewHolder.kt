package com.example.kotlinstudy.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.R
import com.example.kotlinstudy.data.room.Memo

class MemoViewHolder(val context: Context, parent: ViewGroup?, val onItemClickListener: OnItemClickListener?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_memo, parent, false)) {

    val textView by lazy {

        itemView.findViewById(R.id.item_memo_title) as TextView
    }

    fun onBind(item: Memo, position : Int){
        textView.text = item.title

        itemView.setOnClickListener { onItemClickListener?.onItemClick(position) }
    }

}