package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.project.Pages.AccountScreen

data class Patient(
    val id: Int,
    val name: String,
    val doctor: String,
    val age: Int,
    val type: String,
    val status: String
)
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Patients Management",

    ) {
        AccountScreen()
    }
}

