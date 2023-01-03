package com.swancompany.journal.ui.presentation.homeScreen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swancompany.journal.data.models.NoteModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onFabClicked: () -> Unit,
) {
    val viewModel:HomeViewModel = viewModel()
    val notesModel = viewModel.notesModel
    LaunchedEffect(Unit) {
        viewModel.getAllNotes()
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onFabClicked() }) {
                Icon(Icons.Filled.Add,
                    contentDescription = "add")
            }
        },
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(notesModel) { noteModel ->
                NotesCard(noteModel, viewModel)
            }
        }
    }
}

@Composable
fun NotesCard(
    noteModel: NoteModel,
    viewModel: HomeViewModel,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 5.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.fillMaxWidth(.9f)) {
                Text(
                    text = noteModel.title,
                    fontSize = 24.sp
                )
                Text(
                    text = noteModel.notes,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
            IconButton(
                onClick = { viewModel.deleteNote(noteModel)
                    Log.i("HomeScreen","delete icon clicked")
                }
            ) {
                Icon(Icons.Filled.Delete, contentDescription = "delete")
            }
        }
    }
}