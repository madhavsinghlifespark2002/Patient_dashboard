package org.example.project.ApiService

import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import org.example.project.Resourcem
import org.example.project.data.FhirBundle
import org.example.project.httpClient


class ApiService {
    suspend fun fetchPatients(): FhirBundle? {
        return try {
            val response: HttpResponse = httpClient.get("https://lt-internal.el.r.appspot.com/FHIRpatients")
            val responseBody = response.bodyAsText()  // Read response as a string
            val json = Json { ignoreUnknownKeys = true }
            json.decodeFromString<FhirBundle>(responseBody)// Return parsed bundle
        } catch (e: Exception) {
            println("Failed to fetch data: ${e.message}")
            null
        }
    }
    suspend fun fetchPatientsbyId(patientId: String): Resourcem? {
        return try {
            val response: HttpResponse = httpClient.get("https://lt-internal.el.r.appspot.com/patient/${patientId}")
            val responseBody = response.bodyAsText()  // Read response as a string
            val json = Json { ignoreUnknownKeys = true }
            json.decodeFromString<Resourcem>(responseBody)// Return parsed bundle
        } catch (e: Exception) {
            println("Failed to fetch data: ${e.message}")
            null
        }
    }
}
