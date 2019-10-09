package com.example.kotlinstudy.View

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import com.example.kotlinstudy.Contract.WriteContract
import com.example.kotlinstudy.Presenter.WritePresenter
import com.example.kotlinstudy.R
import com.example.kotlinstudy.Room.Memo
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : BaseActivity(), WriteContract.View, View.OnClickListener {
    private var presenter: WriteContract.Presenter?= null
    var memo : Memo = Memo()
    val DIALOG_DATE: Int = 1
    val DIALOG_TIME: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        presenter=WritePresenter(this@WriteActivity, applicationContext, this)
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
            }
        }
    }

    override fun setView(){
        write_date_picker!!.setOnClickListener(this)
        write_time_picker!!.setOnClickListener(this)
        write_button.setOnClickListener(this)
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
}
