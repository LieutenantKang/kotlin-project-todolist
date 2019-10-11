package com.example.kotlinstudy.view.activity.write

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import com.example.kotlinstudy.R
import com.example.kotlinstudy.data.room.Memo
import com.example.kotlinstudy.base.BaseActivity
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : BaseActivity(), WriteContract.View {

    override val layoutRes: Int
        get() = R.layout.activity_write

    var memo : Memo = Memo()
    val DIALOG_DATE: Int = 1
    val DIALOG_TIME: Int = 2

    override fun initView() {
        presenter = WritePresenter(this)
        presenter.start()
    }

    override fun onClickEvent() {
        super.onClickEvent()

        write_date_picker.setOnClickListener { showDialog(DIALOG_DATE) }

        write_time_picker.setOnClickListener { showDialog(DIALOG_TIME) }

        write_button.setOnClickListener {  }
    }

    override fun onCreateDialog(id: Int): Dialog {
        when(id){
            DIALOG_DATE->{
                return DatePickerDialog(this,
                        DatePickerDialog.OnDateSetListener { view, year, month, day ->
                            memo.year = year
                            memo.month = month
                            memo.day = day
                            write_year.text = year.toString()
                            write_month.text = month.toString()
                            write_day.text = day.toString()
                        }, 2019, 1, 1)
            }
            DIALOG_TIME-> {
                return TimePickerDialog(this,
                        TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                            memo.hour = hour
                            memo.minute = minute
                            write_hour.text = hour.toString()
                            write_minute.text = minute.toString()
                        }, 0,0,false)
            }
        }
        return super.onCreateDialog(id)
    }

    // region mvp
    override lateinit var presenter: WriteContract.Presenter

    override fun isViewActive(): Boolean = checkActive()
    // endregion
}
