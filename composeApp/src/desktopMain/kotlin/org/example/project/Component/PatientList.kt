package org.example.project.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import cafe.adriel.voyager.navigator.LocalNavigator
import org.example.project.PatientRow
import org.example.project.data.Patient
import javax.imageio.ImageIO
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.project.ApiService.ApiService
import org.example.project.data.FhirBundle
import org.example.project.routeToScreen
import org.example.project.viewmodels.SharedViewModel

// App Composable to display the patient list
@Composable
fun PatientList(viewModel: SharedViewModel) {
    val repository = ApiService()
    var patientData by remember { mutableStateOf<FhirBundle?>(null) }
    suspend fun fetchPatients() {
        //viewModelScope.launch {
        patientData = repository.fetchPatients()
        // }
    }
    LaunchedEffect(Unit) {
        fetchPatients()
    }
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
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFF8F4))
                                .padding(8.dp)
                                .clickable{

                                },
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("ID", modifier = Modifier.weight(1f))
                            Text("Name", modifier = Modifier.weight(1.5f))
                            Text("Gender", modifier = Modifier.weight(1.5f))
                            Text("Contact", modifier = Modifier.weight(1.5f))
                            Text("Status", modifier = Modifier.weight(1.5f))
                        }
                        LazyColumn(modifier = Modifier.fillMaxWidth()){
                            patientData?.entry?.let { entries ->
                                itemsIndexed(entries) { index, entry ->
                                    entry.resource?.let { patient ->
                                        PatientRow(
                                            backgroundColor = if (index % 2 == 0) Color.White else Color(0xFFF8FAFB),
                                            patient = patient,
                                            viewModel = viewModel
                                        )
                                    }
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