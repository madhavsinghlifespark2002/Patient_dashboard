package org.example.project

import androidx.compose.foundation.background
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

@Composable
fun PatientRow(backgroundColor: Color, patient: Patient) {
    Row(
        modifier = Modifier.fillMaxWidth().background(color = backgroundColor)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(patient.id.toString(), modifier = Modifier.weight(1f))
        Text(patient.name, modifier = Modifier.weight(1.5f))
        Text(patient.doctor, modifier = Modifier.weight(1.5f))
        Text(patient.age.toString(), modifier = Modifier.weight(0.5f))
        Text(patient.type, modifier = Modifier.weight(1f))
        Text(patient.status, modifier = Modifier.weight(1.5f))
    }
}