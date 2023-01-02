package com.swancompany.journal.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.swancompany.journal.data.daos.NoteDao
import com.swancompany.journal.data.models.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase :RoomDatabase(){
abstract fun noteDao() : NoteDao

    companion object {
        private var INSTANCE: NoteDatabase? = null
        fun getInstance(context: Context ): NoteDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "Note_database"
                    )
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}