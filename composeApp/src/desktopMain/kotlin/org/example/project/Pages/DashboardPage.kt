package org.example.project.Pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.Component.DashboardCard
import org.example.project.Component.PatientList
import javax.imageio.ImageIO


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DashboardPage(){
    Column(
        modifier = Modifier.padding(12.dp)
    ){
        Text(text = "Hello", fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Welcome to the Management Dashboard", color = Color.Gray, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            color = Color(0xFFD6D6D6),
            thickness = 1.dp
        )
        val family = useResource("family.png") {
            ImageIO.read(it).toComposeImageBitmap()
        }
        val doctors = useResource("doctors.png") {
            ImageIO.read(it).toComposeImageBitmap()
        }
        val patients = useResource("patients.png") {
            ImageIO.read(it).toComposeImageBitmap()
        }
        val appointment = useResource("appointment.png") {
            ImageIO.read(it).toComposeImageBitmap()
        }
        Row{
            DashboardCard(
                label = "Visitors",
                subContent = "4,592",
                sideContent = "↑ +15.9%",
                content = "Stay informed with real-time data to enhance \n patient care and visitor management.",
                image = family,
                backgroundColor = Color(0xFFDFF3FE),
                //backgroundColor = Color.White
            )
            DashboardCard(
                label = "Physiotherapist",
                subContent = "42",
                sideContent = "↑ +4.9%",
                content = "Stay updated with essential details\n to streamline medical support and management.",
                image = doctors,
                backgroundColor = Color(0xFFEBE1FE),
//                        backgroundColor = Color.White
            )
            DashboardCard(
                label = "Patient",
                subContent = "540",
                sideContent = "↓ -0.9%",
                content = "Keep track of patient information at a glance, \n with easy access to key details for personalized care.",
                image = patients,
                backgroundColor = Color(0xFFFFF0D1),
//                        backgroundColor = Color.White
            )
            DashboardCard(
                label = "Total Sessions",
                subContent = "540",
                sideContent = "↓ -0.9%",
                content = "Keep track of patient information at a glance, \n with easy access to key details for personalized care.",
                image = appointment,
                backgroundColor = Color(0xFFFFF8F4)
                // backgroundColor = Color.White
            )
        }
        Row(
            modifier = Modifier.padding(horizontal = 12.dp)
        ){
            PatientList()
        }

    }
}
