package com.example.kotlinstudy.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

class Memo (var title: String?, var content: String?) {
    var id: Int = 0
}