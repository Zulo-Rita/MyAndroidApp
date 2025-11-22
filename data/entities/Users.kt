package com.example.lecture_2.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "users_table",
    indices = [Index(value = ["nickname"], unique = true)])

class Users(@PrimaryKey(autoGenerate = true)
             var id: Int = 0,
    //  ask the professor about @ColumnInfo
            @ColumnInfo(name = "email")
             val email: String,
            @ColumnInfo(name = "full_name")
             val fullName: String? = null,
            @ColumnInfo(name = "nickname")
             val nickname: String? = null,
            @ColumnInfo(name = "password_hash")
             val passwordHash: String

){


}