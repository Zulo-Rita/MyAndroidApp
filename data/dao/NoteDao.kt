package com.example.lecture_2.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lecture_2.data.entities.Note
import com.example.lecture_2.data.entities.Users

@Dao

interface NoteDao {
    @Insert
    suspend fun insert(note: Users)

    @Query("SELECT * FROM note_table")
    suspend fun gerAll(): List<Note>

    @Query ("DELETE FROM note_table")
    suspend fun deleteAll()
}