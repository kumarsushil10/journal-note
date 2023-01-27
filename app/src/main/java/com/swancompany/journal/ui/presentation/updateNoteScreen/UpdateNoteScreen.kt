package com.swancompany.journal.ui.presentation.updateNoteScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swancompany.journal.data.models.NoteModel
import com.swancompany.journal.ui.presentation.addNoteScreen.AddNoteTopBar

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
    Scaffold(
        topBar = { UpdateNoteTopBar(viewModel,noteId,navigateBack,title,note) },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            TextField(
                value = title,
                onValueChange = { title -> viewModel.updateTitle(title) },
                placeholder = { Text(text = "Title") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )

            TextField(
                value = note,
                onValueChange = { note -> viewModel.updateNote(note) },
                placeholder = { Text(text = "Note") },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
    }
}