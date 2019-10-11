package com.example.kotlinstudy.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Memo {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var title: String? = null
    var content: String? = null
    var year: Int? = null
    var month: Int? = null
    var day: Int? = null
    var hour: Int? = null
    var minute: Int? = null
}