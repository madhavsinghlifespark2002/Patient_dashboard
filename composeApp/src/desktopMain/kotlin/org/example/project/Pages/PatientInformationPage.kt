package org.example.project.Pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.Component.QuestionAnswer
import org.example.project.Resourcem
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PatientInformationPage(patientData: Resourcem?){
    LazyColumn{
        item{
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                val age = calculateAge(patientData?.birthDate)
                Column(
                ){
                    QuestionAnswer("Patient Name", patientData?.name?.firstOrNull { it.use == "official" }
                        ?.let { it.given.joinToString(" ") } ?: " ")
                    Spacer(modifier = Modifier.height(42.dp))
                    QuestionAnswer("Age", age)
                    Spacer(modifier = Modifier.height(42.dp))
                    QuestionAnswer("Gender", patientData?.gender.toString())
                }
                Column(
                ){
                    val assignerName = patientData?.identifier
                        ?.firstOrNull { it.assigner?.display != null }
                        ?.assigner?.display ?: ""
                    val PeriodStart = patientData?.identifier
                        ?.firstOrNull { it.period?.start != null }
                        ?.period?.start ?: ""
                    QuestionAnswer("Id", patientData?.id.toString())
                    Spacer(modifier = Modifier.height(42.dp))
                    QuestionAnswer("Assigner", assignerName)
                    Spacer(modifier = Modifier.height(42.dp))
                    QuestionAnswer("Period-Start", PeriodStart)
                }
                Column(
                ){
                    QuestionAnswer("Birth-Date", patientData?.birthDate.toString())
                    Spacer(modifier = Modifier.height(42.dp))
                    QuestionAnswer("Address", "B-101, Keshnav Nagar, Delhi-110036")
                    Spacer(modifier = Modifier.height(42.dp))
                    QuestionAnswer("Contact", patientData?.telecom?.firstOrNull { it.use == "work" && it.system == "phone" }
                        ?.value ?: " ")
                }
                Column(
                ){
                    QuestionAnswer("Active", patientData?.active.toString())
                    Spacer(modifier = Modifier.height(42.dp))
                    QuestionAnswer("managingOrganization", patientData?.managingOrganization?.reference.toString())
                    Spacer(modifier = Modifier.height(42.dp))
                    QuestionAnswer("resourceType", patientData?.resourceType.toString())
                }
            }
        }
    }

}
fun calculateAge(birthDateString: String?): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val birthDate = LocalDate.parse(birthDateString, formatter)
        val currentDate = LocalDate.now()
        val age = Period.between(birthDate, currentDate).years
        age.toString()
    } catch (e: Exception) {
        ""
    }
}
