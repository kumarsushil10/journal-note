package com.swancompany.journal.ui.presentation.updateNoteScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swancompany.journal.data.models.NoteModel

@Composable
fun UpdateNoteScreen(
    noteId: Int,
    navigateBack: () -> Unit,
) {
    val viewModel: UpdateNoteViewModel = viewModel()
    LaunchedEffect(Unit) {
        viewModel.getNoteById(noteId)
    }
    val title = viewModel.noteModel.title
    val note = viewModel.noteModel.notes
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = title,
            onValueChange = { title -> viewModel.updateTitle(title) },
            placeholder = {
                Text(
                    text = "Title"
                )
            }
        )

        TextField(
            value = note,
            onValueChange = { note -> viewModel.updateNote(note) },
            placeholder = {
                Text(
                    text = "note"
                )
            }
        )
        Button(
            onClick = {
                val updateNote = NoteModel(noteId, title, note)
                viewModel.updateNotes(updateNote)
                navigateBack()
            }
        ) {
            Text(
                text = "Update"
            )
        }
    }
}