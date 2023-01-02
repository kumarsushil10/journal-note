package com.swancompany.journal.domain

import android.app.Application
import com.swancompany.journal.data.daos.NoteDao
import com.swancompany.journal.data.database.NoteDatabase
import com.swancompany.journal.data.models.NoteModel
import kotlinx.coroutines.flow.Flow

class NoteRepository(application: Application) {
    private var noteDao: NoteDao

    init {
        val database = NoteDatabase.getInstance(application)
        noteDao = database.noteDao()
    }

    fun getAllNotesFromRoom(): Flow<List<NoteModel>> = noteDao.getAllNotes()
    suspend fun insertNoteToRoom(noteModel: NoteModel) = noteDao.insertNote(noteModel)
    suspend fun updateNoteInRoom(noteModel: NoteModel) = noteDao.updateNote(noteModel)
    suspend fun deleteNoteFromRoom(noteModel: NoteModel) = noteDao.deleteNote(noteModel)
//    suspend fun insertAllNotesInRoom(noteList: List<NoteModel>) = noteDao.inertAllNotes(noteList)
//    suspend fun getNoteByIdFromRoom(noteId: String?) = noteDao.getNoteById(noteId)

}