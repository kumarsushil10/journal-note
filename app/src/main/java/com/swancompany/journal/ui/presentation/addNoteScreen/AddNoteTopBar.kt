package com.swancompany.journal.ui.presentation.addNoteScreen

import android.util.Log
import android.widget.Toast
import androidx.compose.material3.*
import com.swancompany.journal.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.swancompany.journal.data.models.NoteModel

@Composable
fun AddNoteTopBar(
    viewModel: AddNoteViewModel,
    navigateBack: () -> Unit,
    title: String,
    notes: String,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(stringResource(R.string.note))
        },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(painterResource(R.drawable.ic_baseline_clear_24),
                    contentDescription = "logo")
            }
        },
        actions = {
            IconButton(onClick = {
                if (title.isNotEmpty() || notes.isNotEmpty()){
                    val noteModel = NoteModel(id = 0, title = title, notes = notes)
                    viewModel.insertNote(noteModel)
                    navigateBack()
                }else{
                    navigateBack()
                }
            }) {
                Icon(painterResource(id = R.drawable.ic_baseline_check_24),
                    contentDescription = "Git")
            }
        }
    )
}