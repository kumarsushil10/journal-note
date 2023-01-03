
package com.swancompany.journal.data.daos

import androidx.room.*
import com.swancompany.journal.data.models.NoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT *FROM noteModel ORDER BY ID ASC")
    fun getAllNotes(): Flow<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteModel: NoteModel)

    @Update
    suspend fun updateNote(noteModel: NoteModel)

    @Delete
    suspend fun deleteNote(noteModel: NoteModel)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun inertAllNotes(noteList: List<NoteModel>)
//
//    @Query("SELECT *FROM noteModel WHERE id = :noteId")
//    suspend fun getNoteById(noteId: String?): NoteModel
}