package com.example.kotlinstudy.util

import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

fun Context.showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
fun Context.showToast(res: Int) = Toast.makeText(this, res, Toast.LENGTH_SHORT).show()
fun Context.showToastLong(message: String) { Toast.makeText(this, message, Toast.LENGTH_LONG).show() }
fun Context.showToastLong(@StringRes messageRes: Int) { Toast.makeText(this, messageRes, Toast.LENGTH_LONG).show() }

// region Dialog or Message
fun Context.alertDialog(@StringRes messageId: Int, listener: DialogInterface.OnClickListener? = null) {
    alertDialog(getString(messageId), listener)
}

fun Context.alertDialog(message: String, listener: DialogInterface.OnClickListener? = null) {
    AlertDialog.Builder(this)
            .setCancelable(false)
            .setMessage(message)
            .setPositiveButton(android.R.string.ok, listener)
            .show()
}

fun Context.confirmDialog(@StringRes messageId: Int,
                          okListener: DialogInterface.OnClickListener? = null,
                          cancelListener: DialogInterface.OnClickListener? = null) {
    confirmDialog(getString(messageId), okListener, cancelListener)
}

fun Context.confirmDialog(@StringRes messageId: Int,
                          okListener: DialogInterface.OnClickListener? = null,
                          cancelListener: DialogInterface.OnClickListener? = null,
                          positiveTextResId: Int? = null,
                          negativeTextResId: Int? = null) {
    confirmDialog(getString(messageId), okListener, cancelListener, positiveTextResId, negativeTextResId)
}

fun Context.confirmDialog(message: String,
                          okListener: DialogInterface.OnClickListener? = null,
                          cancelListener: DialogInterface.OnClickListener? = null,
                          positiveTextResId: Int? = null,
                          negativeTextResId: Int? = null) {
    AlertDialog.Builder(this)
            .setCancelable(false)
            .setMessage(message)
            .setPositiveButton(positiveTextResId ?: android.R.string.ok, okListener)
            .setNegativeButton(android.R.string.cancel, cancelListener)
            .show()
}

fun Context.confirmDialogCustom(@StringRes messageId: Int, okText: String, noText: String,
                                okListener: DialogInterface.OnClickListener? = null,
                                cancelListener: DialogInterface.OnClickListener? = null) {
    confirmDialogCustom(getString(messageId), okText, noText, okListener, cancelListener)
}

fun Context.confirmDialogCustom(message: String, okText: String, noText: String,
                                okListener: DialogInterface.OnClickListener? = null,
                                cancelListener: DialogInterface.OnClickListener? = null) {
    AlertDialog.Builder(this)
            .setCancelable(false)
//        .setTitle("AlertDialog Title")
            .setMessage(message)
            .setPositiveButton(okText, okListener)
            .setNegativeButton(noText, cancelListener)
            .create().show()
}
// endregion