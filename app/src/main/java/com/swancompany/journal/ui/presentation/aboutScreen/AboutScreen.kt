package com.swancompany.journal.ui.presentation.aboutScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen(
    navigateBack: () -> Unit,
) {
    Scaffold(
        topBar = { AboutTopBar(navigateBack) },
        backgroundColor = colorScheme.surface
    ) {
        Surface(
            color = colorScheme.background,
            shape = RoundedCornerShape(32.dp, 32.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Button(onClick = { /*TODO*/ }) {

                }
            }
        }
    }
}