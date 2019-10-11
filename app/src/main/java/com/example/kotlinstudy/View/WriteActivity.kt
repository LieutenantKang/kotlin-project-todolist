package com.example.kotlinstudy.View

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.kotlinstudy.Contract.WriteContract
import com.example.kotlinstudy.Presenter.WritePresenter
import com.example.kotlinstudy.R
import com.example.kotlinstudy.Room.Memo
import kotlinx.android.synthetic.main.activity_write.*
import java.util.*

class WriteActivity : BaseActivity(), WriteContract.View, View.OnClickListener {
    private var presenter: WriteContract.Presenter? = null
    var memo: Memo = Memo()
    var calendar: Calendar = Calendar.getInstance()
    val DIALOG_DATE: Int = 1
    val DIALOG_TIME: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        presenter = WritePresenter(this@WriteActivity, applicationContext, this)
        presenter!!.presenterView()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.write_date_picker -> {
                showDialog(DIALOG_DATE)
            }
            R.id.write_time_picker -> {
                showDialog(DIALOG_TIME)
            }
            R.id.write_button -> {
                memo.title = write_title.text.toString()
                memo.content = write_content.text.toString()
                presenter!!.insertMemo(memo)
                val intent = Intent()
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    override fun setView() {
        write_date_picker!!.setOnClickListener(this)
        write_time_picker!!.setOnClickListener(this)
        write_button.setOnClickListener(this)

        write_year.text = calendar.get(Calendar.YEAR).toString() + "년"
        write_month.text = (calendar.get(Calendar.MONTH) + 1).toString() + "월"
        write_day.text = calendar.get(Calendar.DAY_OF_MONTH).toString() + "일"
        write_hour.text = calendar.get(Calendar.HOUR_OF_DAY).toString()
        if (calendar.get(Calendar.MINUTE) < 10) {
            write_minute.text = "0" + calendar.get(Calendar.MINUTE).toString()
        } else {
            write_minute.text = calendar.get(Calendar.MINUTE).toString()
        }

        memo.year = calendar.get(Calendar.YEAR)
        memo.month = calendar.get(Calendar.MONTH) + 1
        memo.day = calendar.get(Calendar.DAY_OF_MONTH)
        memo.hour = calendar.get(Calendar.HOUR_OF_DAY)
        memo.minute = calendar.get(Calendar.MINUTE)
    }

    override fun onCreateDialog(id: Int): Dialog {
        when (id) {
            DIALOG_DATE -> {
                return DatePickerDialog(this,
                        DatePickerDialog.OnDateSetListener { view, year, month, day ->
                            memo.year = year
                            memo.month = month + 1
                            memo.day = day
                            write_year.text = year.toString() + "년"
                            write_month.text = (month + 1).toString() + "월"
                            write_day.text = day.toString() + "일"
                        }, 2019, 1, 1)
            }
            DIALOG_TIME -> {
                return TimePickerDialog(this,
                        TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                            memo.hour = hour
                            memo.minute = minute
                            write_hour.text = hour.toString()
                            if (minute < 10) {
                                write_minute.text = "0" + minute.toString()
                            } else {
                                write_minute.text = minute.toString()
                            }
                        }, 0, 0, false)
            }
        }
        return super.onCreateDialog(id)
    }
}
