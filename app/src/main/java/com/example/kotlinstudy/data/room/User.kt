package com.example.kotlinstudy.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 필요한 정보 : id, email, pw, 최신 로그인 날짜 or 유무?
 */
@Entity
data class User(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var email: String,
        var password: String,
        var isLatestLogin: Boolean
)
//class User(var email: String?, var pw: String?) {
//    @PrimaryKey(autoGenerate = true)
//    var id: Int = 0
//}
