package com.swancompany.journal.ui.presentation.addNoteScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swancompany.journal.data.models.NoteModel
import com.swancompany.journal.ui.theme.JournalTheme

@Composable
fun AddNoteScreen() {
    val viewModel:AddNoteViewModel = viewModel()
    var title by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            placeholder = { Text("Title") },
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
            value = notes,
            onValueChange = {notes = it},
            placeholder = {Text("notes")},
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
        Button(
            onClick = {
                val noteModel = NoteModel(id = 0,title = title ,notes = notes)
                viewModel.insertNote(noteModel)
                Log.i("AddNoteScreen","add Button clicked")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add")
        }
    }
}