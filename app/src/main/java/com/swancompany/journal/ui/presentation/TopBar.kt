package com.swancompany.journal.ui.presentation

import androidx.compose.material3.*
import com.swancompany.journal.R

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.swancompany.journal.ui.JournalAppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    currentScreen: JournalAppScreens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(stringResource(currentScreen.title))
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(painterResource(R.drawable.ic_baseline_arrow_back_ios_24 ),
                        contentDescription = "Back Button"
                    )
                }
            } else {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(R.drawable.ic_baseline_view_headline_24),
                        contentDescription = "Menu")
                }
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(id = R.drawable.ic_baseline_more_vert_24),
                    contentDescription = "Git")
            }
        }
    )
}