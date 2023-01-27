package com.swancompany.journal.ui.presentation.updateNoteScreen

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.swancompany.journal.R
import com.swancompany.journal.data.models.NoteModel

@Composable
fun UpdateNoteTopBar(
    viewModel: UpdateNoteViewModel,
    noteId: Int,
    navigateBack: () -> Unit,
    title: String,
    note: String,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(painterResource(R.drawable.ic_baseline_clear_24),
                    contentDescription = "back")
            }
        },
        actions = {
            IconButton(onClick = {
                val updateNote = NoteModel(noteId, title, note)
                viewModel.updateNotes(updateNote)
                navigateBack()
            }) {
                Icon(painterResource(id = R.drawable.ic_baseline_check_24),
                    contentDescription = "save")
            }
        }
    )
}