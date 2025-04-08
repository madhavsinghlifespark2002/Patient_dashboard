package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.project.data.FhirBundle
import org.example.project.data.Patient

@Composable
fun PatientRow(backgroundColor: Color, patient: Resourcem) {
    val navigator = LocalNavigator.currentOrThrow
    Row(
        modifier = Modifier.fillMaxWidth().background(color = backgroundColor)
            .padding(8.dp).clickable{
                navigator.push(routeToScreen("/details"))
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
//        Text(patient.entry, modifier = Modifier.weight(1f))
        Text(patient.id.toString(), modifier = Modifier.weight(1f))
        Text(
            patient.name.firstOrNull { it.use == "official" }
                ?.let { it.given.joinToString(" ") } ?: "N/A",
            modifier = Modifier.weight(1.5f)
        )
        Text(patient.gender.toString(), modifier = Modifier.weight(1.5f))
        Text(
            patient.telecom.firstOrNull { it.use == "work" && it.system == "phone" }
                ?.value ?: "N/A",
            modifier = Modifier.weight(1.5f)
        )
        Text(patient.active.toString(), modifier = Modifier.weight(1.5f))
//        Text(patient.doctor, modifier = Modifier.weight(1.5f))
//        Text(patient.age.toString(), modifier = Modifier.weight(0.5f))
//        Text(patient.type, modifier = Modifier.weight(1f))
//        Text(patient.status, modifier = Modifier.weight(1.5f))
    }
}
//
//@Composable
//fun PatientRow(backgroundColor: Color, patient: Resourcem) {
//    val navigator = LocalNavigator.currentOrThrow
//
//    // Get official or usual name
//    val displayName = patient.name
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = backgroundColor)
//            .padding(8.dp)
//            .clickable {
//                navigator.push(routeToScreen("/details"))
//            },
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(displayName.toString(), modifier = Modifier.weight(1f))
//    }
//}