package com.swancompany.journal.ui.presentation.updateNoteScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.swancompany.journal.R
import com.swancompany.journal.data.models.NoteModel
import com.swancompany.journal.ui.presentation.addNoteScreen.AddNoteTopBar

@Composable
fun UpdateNoteScreen(
    noteId: Int,
    navigateBack: () -> Unit,
) {
    val viewModel: UpdateNoteViewModel = viewModel()
    val title = viewModel.noteModel.title
    val note = viewModel.noteModel.notes
    val focusManager = LocalFocusManager.current

    LaunchedEffect(Unit) {
        viewModel.getNoteById(noteId)
    }
    Scaffold(
        topBar = { UpdateNoteTopBar(viewModel, noteId, navigateBack, title, note) },
        backgroundColor = colorScheme.surface

    ) {
        Surface(
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(32.dp, 32.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                TextField(
                    value = title,
                    onValueChange = { title -> viewModel.updateTitle(title) },
                    placeholder = { Text(text = "Title",color = colorScheme.onSurface) },
                    textStyle = TextStyle(
                        color = colorScheme.onSurface,
                        fontFamily = FontFamily(Font(R.font.assistant_regular)),
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.LightGray,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        capitalization = KeyboardCapitalization.Sentences,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }),
                )

                TextField(
                    value = note,
                    onValueChange = { note -> viewModel.updateNote(note) },
                    placeholder = { Text(text = "Note",color = colorScheme.onSurface) },
                    textStyle = TextStyle(color = colorScheme.onSurface,
                        fontFamily = FontFamily(Font(R.font.assistant_regular)),
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        capitalization = KeyboardCapitalization.Sentences,
                        keyboardType = KeyboardType.Text,
                    ),
                )
            }
        }
    }
}