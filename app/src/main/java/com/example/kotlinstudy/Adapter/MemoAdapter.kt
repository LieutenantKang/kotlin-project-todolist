package com.example.kotlinstudy.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.Contract.AdapterContract
import com.example.kotlinstudy.R
import com.example.kotlinstudy.Room.Memo
import com.example.kotlinstudy.View.UpdateActivity
import kotlinx.android.synthetic.main.item_memo.view.*

class MemoAdapter(val context: Context) : AdapterContract.View, AdapterContract.Model, RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    private lateinit var memoList : ArrayList<Memo>

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        memoList[position].let{ item ->
            with(holder) {
                memoTitle.text = item.title
            }
        }

        holder.memoLayout.setOnClickListener {
            val intent = Intent(context, UpdateActivity::class.java)
            intent.putExtra("memo_id", memoList.get(position).id)
            (context as Activity).startActivityForResult(intent, 1000)
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
        val memoTitle: TextView = view.item_memo_title
        val memoLayout: LinearLayout = view.item_layout
    }

    override fun getMemoId(position: Int): Int {
        return memoList[position].id
    }

    override fun removeItem(position: Int) {
        memoList.removeAt(position)
    }
}