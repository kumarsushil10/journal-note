package com.swancompany.journal.ui

sealed class JournalAppScreens(val name : String){
    object Home : JournalAppScreens("home")
    object AddNotes : JournalAppScreens("add_note")
    object UpdateNotes : JournalAppScreens("update_note/{id}")
    object About:JournalAppScreens("about")
}