package com.example.kotlinstudy.View

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.kotlinstudy.Contract.UpdateContract
import com.example.kotlinstudy.Presenter.UpdatePresenter
import com.example.kotlinstudy.R
import com.example.kotlinstudy.Room.Memo
import kotlinx.android.synthetic.main.activity_update.*
import java.util.*

class UpdateActivity : BaseActivity(), UpdateContract.View, View.OnClickListener {
    private var presenter: UpdateContract.Presenter? = null
    var memoId : Int = -1
    var memo: Memo = Memo()
    val DIALOG_DATE: Int = 1
    val DIALOG_TIME: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        presenter = UpdatePresenter(this@UpdateActivity, applicationContext, this)
        presenter!!.presenterView()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.update_date_picker -> {
                showDialog(DIALOG_DATE)
            }
            R.id.update_time_picker -> {
                showDialog(DIALOG_TIME)
            }
            R.id.update_button -> {
                memo.title = update_title.text.toString()
                memo.content = update_content.text.toString()
                presenter!!.updateMemo(memoId, memo)
                val baseIntent = Intent()
                setResult(RESULT_OK, baseIntent)
                finish()
            }
        }
    }

    override fun setView() {
        memoId = intent.getIntExtra("memo_id", -1)
        memo = presenter!!.getMemo(memoId)

        update_date_picker!!.setOnClickListener(this)
        update_time_picker!!.setOnClickListener(this)
        update_button.setOnClickListener(this)

        update_title.setText(memo.title)
        update_content.setText(memo.content)
        update_year.text = memo.year.toString()
        update_month.text = memo.month.toString()
        update_day.text = memo.day.toString()
        update_hour.text = memo.hour.toString()
        update_minute.text = memo.minute.toString()
    }

    override fun onCreateDialog(id: Int): Dialog {
        when (id) {
            DIALOG_DATE -> {
                return DatePickerDialog(this,
                        DatePickerDialog.OnDateSetListener { view, year, month, day ->
                            memo.year = year
                            memo.month = month + 1
                            memo.day = day
                            update_year.text = year.toString() + "년"
                            update_month.text = (month + 1).toString() + "월"
                            update_day.text = day.toString() + "일"
                        }, memo.year!!, memo.month!!, memo.minute!!)
            }
            DIALOG_TIME -> {
                return TimePickerDialog(this,
                        TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                            memo.hour = hour
                            memo.minute = minute
                            update_hour.text = hour.toString()
                            if (minute < 10) {
                                update_minute.text = "0" + minute.toString()
                            } else {
                                update_minute.text = minute.toString()
                            }
                        }, memo.hour!!, memo.minute!!, false)
            }
        }
        return super.onCreateDialog(id)
    }
}
