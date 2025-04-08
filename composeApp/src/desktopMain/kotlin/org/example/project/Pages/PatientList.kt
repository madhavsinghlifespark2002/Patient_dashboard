package org.example.project.Pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.ApiService.ApiService
import org.example.project.data.FhirBundle

@Composable
fun PatientListScreen() {
    val repository = ApiService()
    //  val patients by viewModel.patients.collectAsState()
    var patientData by remember { mutableStateOf<FhirBundle?>(null) }

    suspend fun fetchPatients() {
        //viewModelScope.launch {
        patientData = repository.fetchPatients()
        // }
    }
    LaunchedEffect(Unit) {
        fetchPatients()
    }


    Scaffold(topBar = { TopAppBar(title = { Text("FHIR Patients") }) }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
            Text(text = patientData?.toString() ?: "No data received", modifier = Modifier.fillMaxWidth())
        }
    }
}
