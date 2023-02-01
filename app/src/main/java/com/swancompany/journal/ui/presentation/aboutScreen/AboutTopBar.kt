package com.swancompany.journal.ui.presentation.aboutScreen

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.swancompany.journal.R
import com.swancompany.journal.data.models.NoteModel
import com.swancompany.journal.ui.presentation.addNoteScreen.AddNoteViewModel

@Composable
fun AboutTopBar(
    navigateBack: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                stringResource(R.string.about),
                fontFamily = FontFamily(Font(R.font.playfair_display_regular)),
            )
        },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(painterResource(R.drawable.ic_baseline_arrow_back_ios_24),
                    contentDescription = "logo")
            }
        },
    )
}