package com.swancompany.journal.ui.presentation.addNoteScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AddNoteScreen(
    navigateBack: () -> Unit,
) {
    val viewModel: AddNoteViewModel = viewModel()
    var title by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Scaffold(
        topBar = { AddNoteTopBar(viewModel, navigateBack, title, notes) },
    ) {
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
                    focusedIndicatorColor = Color.LightGray,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Sentences,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
            )
            TextField(
                value = notes,
                onValueChange = { notes = it },
                placeholder = { Text("notes") },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
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