package org.example.project.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.Patient
import org.example.project.PatientRow
import javax.imageio.ImageIO

// App Composable to display the patient list
@Composable
fun PatientList() {
    val patientList = listOf(
        Patient(1, "John Doe", "Dr. Smith", 30, "Outpatient", "Admitted"),
        Patient(2, "Jane Smith", "Dr. Brown", 45, "Inpatient", "Discharged"),
        Patient(3, "Alice Johnson", "Dr. Adams", 50, "Outpatient", "Admitted"),
        Patient(4, "Robert Brown", "Dr. White", 60, "Inpatient", "Discharged"),
        Patient(5, "Emily Davis", "Dr. Clark", 27, "Outpatient", "Admitted"),
        Patient(6, "Michael Wilson", "Dr. Lewis", 33, "Inpatient", "Discharged"),
        Patient(7, "Sarah Miller", "Dr. Hall", 40, "Outpatient", "Admitted"),
        Patient(8, "David Anderson", "Dr. Young", 55, "Inpatient", "Discharged"),
        Patient(9, "Emma Thomas", "Dr. Martin", 23, "Outpatient", "Admitted"),
        Patient(10, "Daniel Moore", "Dr. Thompson", 48, "Inpatient", "Discharged"),
        Patient(11, "Sophia White", "Dr. Walker", 37, "Outpatient", "Admitted"),
        Patient(12, "James Harris", "Dr. Harris", 52, "Inpatient", "Discharged"),
        Patient(13, "Olivia Martin", "Dr. Evans", 29, "Outpatient", "Admitted"),
        Patient(14, "William Thompson", "Dr. Carter", 65, "Inpatient", "Discharged"),
        Patient(15, "Charlotte Lee", "Dr. Scott", 34, "Outpatient", "Admitted"),
        Patient(16, "Benjamin Clark", "Dr. King", 41, "Inpatient", "Discharged"),
        Patient(17, "Amelia Walker", "Dr. Wright", 22, "Outpatient", "Admitted"),
        Patient(18, "Henry Lewis", "Dr. Lopez", 47, "Inpatient", "Discharged"),
        Patient(19, "Evelyn Hall", "Dr. Hill", 39, "Outpatient", "Admitted"),
        Patient(20, "Alexander Young", "Dr. Madhav", 58, "Inpatient", "Discharged")
    )
    Column{

        Spacer(modifier = Modifier.height(12.dp))
        Row{
            Column{
                Row{
                    Text(text = "Patients", fontSize = 20.sp, color = Color(0xFF222429))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Card(
                    elevation = 4.dp,
                    backgroundColor = Color.White,
                    modifier = Modifier.fillMaxWidth(0.75f)
                ){

                    Column(
                        modifier = Modifier.padding(16.dp).height(550.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().background(color = Color(0xFFFFF8F4)).padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("ID", modifier = Modifier.weight(1f))
                            Text("Name", modifier = Modifier.weight(1.5f))
                            Text("Doctor", modifier = Modifier.weight(1.5f))
                            Text("Age", modifier = Modifier.weight(0.5f))
                            Text("Type", modifier = Modifier.weight(1f))
                            Text("Status", modifier = Modifier.weight(1.5f))
                        }
                        LazyColumn(modifier = Modifier.fillMaxWidth()){
                            patientList.forEachIndexed {index, patient ->
                                item{
                                    PatientRow(
                                        backgroundColor = if (index % 2 == 0) Color.White else Color(0xFFF8FAFB),
                                        patient
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column{
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(text = "Doctors", fontSize = 20.sp, color = Color(0xFF222429))
                    Text(text = "See All", fontSize = 18.sp, color = Color(0xFF00c9cf))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Card(
                    elevation = 4.dp,
                    backgroundColor = Color.White,
                    modifier = Modifier.fillMaxWidth()
                ){
                    val doctorImg = useResource("doctorReal.png") {
                        ImageIO.read(it).toComposeImageBitmap()
                    }
                    val doctorImg2 = useResource("doctorReal2.png") {
                        ImageIO.read(it).toComposeImageBitmap()
                    }
                    val doctorImg3 = useResource("doctorReal3.png") {
                        ImageIO.read(it).toComposeImageBitmap()
                    }
                    val doctorImg4 = useResource("doctorReal4.png") {
                        ImageIO.read(it).toComposeImageBitmap()
                    }
                    val doctorImg5 = useResource("doctorReal5.png") {
                        ImageIO.read(it).toComposeImageBitmap()
                    }
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ){
                        doctorCard(
                            image =  doctorImg,
                            title = "Albert Flores",
                            position = "Neurological",
                            status = "Available"
                        )
                        doctorCard(
                            image =  doctorImg2,
                            title = "Marvin McKinney",
                            position = "Orthopedic",
                            status = "Absent"
                        )
                        doctorCard(
                            image =  doctorImg3,
                            title = "Jenny Wilson",
                            position = "Cardiopulmonary",
                            status = "Available"
                        )
                        doctorCard(
                            image =  doctorImg4,
                            title = "Albert Flores",
                            position = "Pediatric",
                            status = "Available"
                        )
                        doctorCard(
                            image =  doctorImg4,
                            title = "Courtney Henry",
                            position = "Geriatric",
                            status = "Available"
                        )
                        doctorCard(
                            image = doctorImg,
                            title = "Eleanor Pena",
                            position = "Sports",
                            status = "Available"
                        )
                        doctorCard(
                            image = doctorImg2,
                            title = "Guy Hawkins",
                            position = "Vestibular",
                            status = "Absent"
                        )
                        doctorCard(
                            image = doctorImg4,
                            title = "Wade Warren",
                            position = "Sports",
                            status = "Available"
                        )
                    }
                }
            }

        }

    }
}
@Composable
fun doctorCard(image: ImageBitmap, title: String, position: String, status: String){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row{
            Image(
                painter = BitmapPainter(image),
                contentDescription = "logo",
                modifier = Modifier
                    .size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column{
                Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = position, fontSize = 16.sp, fontWeight = FontWeight.Light)
            }

        }
        Text(text = status)
    }
    Spacer(modifier = Modifier.height(8.dp))
    Divider()
    Spacer(modifier = Modifier.height(8.dp))
}