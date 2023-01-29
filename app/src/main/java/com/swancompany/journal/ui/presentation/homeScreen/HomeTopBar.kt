package com.swancompany.journal.ui.presentation.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import com.swancompany.journal.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun HomeTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(stringResource(R.string.app_name))
        },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(
                    id = R.drawable.about),
                    contentDescription = "about")
            }
        }
    )
}