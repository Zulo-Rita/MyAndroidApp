package com.example.lecture_2.data.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lecture_2.data.dao.NoteDao
import com.example.lecture_2.data.entities.Note




import java.net.ContentHandler

@Database(entities = [Note::class], version = 1)
abstract class AppDB : RoomDatabase(){

    abstract fun noteDao() : NoteDao
    companion object {
        fun get(context: Context) = Room.databaseBuilder(
            context, AppDB::class.java, "notes.db"
        ).build()
    }
}