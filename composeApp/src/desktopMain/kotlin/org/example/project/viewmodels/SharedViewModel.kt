package org.example.project.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var selectedItem = mutableStateOf("Dashboard")
    var patientId = mutableStateOf("")
}