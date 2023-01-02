package com.swancompany.journal.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.swancompany.journal.R
import com.swancompany.journal.data.models.NoteModel
import com.swancompany.journal.ui.presentation.TopBar
import com.swancompany.journal.ui.presentation.addNoteScreen.AddNoteScreen
import com.swancompany.journal.ui.presentation.homeScreen.HomeScreen
import com.swancompany.journal.ui.presentation.homeScreen.HomeViewModel

enum class JournalAppScreens(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Notes(title = R.string.note),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalApp(
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        JournalAppScreens.valueOf(
            backStackEntry?.destination?.route ?: JournalAppScreens.Home.name
        )
    Scaffold(
        topBar = {
            TopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { padding ->
        NavHost(navController = navController,
            startDestination = JournalAppScreens.Home.name,
            modifier = Modifier.padding(padding)
        ) {
            composable(route = JournalAppScreens.Home.name) {
                HomeScreen(onFabClicked = {navController.navigate(JournalAppScreens.Notes.name)})
            }
            composable(route = JournalAppScreens.Notes.name) {
                AddNoteScreen()
            }
        }
    }
}
