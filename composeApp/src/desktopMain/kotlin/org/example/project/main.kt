package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import org.example.project.Pages.AccountScreen
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

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
        val viewModel = remember { PatientViewModel() }

        PatientListScreen()
//        PatientListScreen(viewModel = viewModel)

        // Appmain()
      //  AccountScreen()
    }
}
class PatientViewModel : ViewModel() {
    private val repository = ApiService()
    init {
        fetchPatients()
    }
    private fun fetchPatients() {
        viewModelScope.launch {
           repository.fetchPatients()
        }
    }
}

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

//@Composable
//fun PatientCard(patient: FhirPatient) {
//    Card(modifier = Modifier.fillMaxWidth().padding(8.dp), elevation = 4.dp) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text("ID: ${patient.id}")
//            Text("Name: ${patient.names?.firstOrNull()?.given?.joinToString(" ") ?: "Unknown"} ${patient.names?.firstOrNull()?.family ?: ""}")
//            Text("Gender: ${patient.gender ?: "Unknown"}")
//            Text("Birthdate: ${patient.birthDate ?: "Unknown"}")
//        }
//    }
//}
//class ApiService {
//    suspend fun fetchPatients(): Entry{
//            val response: HttpResponse = httpClient.get("https://lt-internal.el.r.appspot.com/FHIRpatients")
//            return response.body()
////        } catch (e: Exception) {
////            //"Failed to fetch data: ${e.message}"
////        }
//    }
//}
class ApiService {
    suspend fun fetchPatients(): FhirBundle? {
        return try {
            val response: HttpResponse = httpClient.get("https://lt-internal.el.r.appspot.com/FHIRpatients")
            val responseBody = response.bodyAsText()  // Read response as a string

            println("Raw API Response: $responseBody")  // Debugging

            // Deserialize response into FhirBundle
            val json = Json { ignoreUnknownKeys = true }
            json.decodeFromString<FhirBundle>(responseBody)// Return parsed bundle
        } catch (e: Exception) {
            println("Failed to fetch data: ${e.message}")
            null
        }
    }
}
@Serializable
data class FhirBundle(
    val entry: List<Entry>? = null,
    val link: List<Link>? = null,
    val resourceType: String? = null,
    val total: Int? = null,
    val type: String? = null,
)
@Serializable
data class Entry(
    var fullUrl: String? = null,
    var resource: Resourcem? = null,
    var search: Search? = null
)