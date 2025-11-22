package com.example.lecture_2.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")

class Note (    @PrimaryKey(autoGenerate = true) val id: Int=0,
                val text: String){


}