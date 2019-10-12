package com.example.kotlinstudy.data.model

import com.example.kotlinstudy.common.Const
import com.example.kotlinstudy.util.getPrefBoolean

class LoadingModel {
    fun getIsAutoLogin() = getPrefBoolean(Const.PREF.IS_AUTO_LOGIN, false)
}