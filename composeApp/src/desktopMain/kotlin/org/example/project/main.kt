package org.example.project

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import org.example.project.Component.DetailsPage
import org.example.project.Pages.AccountPage
import org.example.project.viewmodels.SharedViewModel
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Patients Management",

    ) {
        val sharedViewModel = rememberSharedViewModel()
     //  PatientListScreen()
       // Navigator(HomeScreen)
        Navigator(routeToScreen("/home",sharedViewModel ))
       //  Appmain()
      // AccountScreen()
    }
}
@Composable
fun rememberSharedViewModel(): SharedViewModel {
    return remember {
        SharedViewModel()
    }
}
fun routeToScreen(route: String, sharedViewModel: SharedViewModel): Screen {
    return when (route) {
        "/home" -> AccountScreen(sharedViewModel)
        else -> AccountScreen(sharedViewModel)
    }
}

class AccountScreen( private val sharedViewModel: SharedViewModel) : Screen {
    @Composable
    override fun Content() {
        AccountPage(sharedViewModel)
    }
}

