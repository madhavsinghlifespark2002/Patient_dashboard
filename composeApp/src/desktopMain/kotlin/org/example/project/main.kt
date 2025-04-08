package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.project.ApiService.ApiService
import org.example.project.Pages.AccountScreen
import org.example.project.Pages.PatientListScreen
import org.example.project.data.FhirBundle


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Patients Management",

    ) {

     //  PatientListScreen()
       // Navigator(HomeScreen)
        Navigator(routeToScreen("/home"))
       //  Appmain()
      // AccountScreen()
    }
}
fun routeToScreen(route: String): Screen {
    return when (route) {
        "/home" -> AccountScreen
        "/details" -> DetailsScreen
        else -> AccountScreen
    }
}

// Define Screens properly as objects implementing Screen
object AccountScreen : Screen {
    @Composable
    override fun Content() {
        AccountScreen()
    }
}

object DetailsScreen : Screen {
    @Composable
    override fun Content() {
        Text("This is the Details Screen")
    }
}

// ─────────────────────────────────────
// Route Helper
// ─────────────────────────────────────
//fun routeToScreen(route: String): Screen {
//    return when (route) {
//        "/home" -> AccountScreen()
//        "/details" -> DetailsScreen()
//        else -> HomeScreen()
//    }
//}

