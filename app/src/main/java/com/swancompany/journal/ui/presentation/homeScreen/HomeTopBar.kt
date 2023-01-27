package com.swancompany.journal.ui.presentation.homeScreen

import androidx.compose.material3.*
import com.swancompany.journal.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun HomeTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(stringResource(R.string.app_name))
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "logo")
            }
        }
    )
}