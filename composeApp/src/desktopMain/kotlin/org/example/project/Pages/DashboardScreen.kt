package org.example.project.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import org.example.project.Component.AccountInfoItem
import org.example.project.Component.DetailsPage
import org.example.project.viewmodels.SharedViewModel
import javax.imageio.ImageIO

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AccountPage(viewModel: SharedViewModel) {
    var selectedItem by viewModel.selectedItem
    Row(
        modifier = Modifier.fillMaxWidth().padding(12.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(0.2f).fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                val imageBitmap = useResource("logo.png") {
                    ImageIO.read(it).toComposeImageBitmap()
                }
                val dashboard = useResource("dashboard.png") {
                    ImageIO.read(it).toComposeImageBitmap()
                }
                val groups = useResource("groups.png") {
                    ImageIO.read(it).toComposeImageBitmap()
                }
                val person = useResource("person.png") {
                    ImageIO.read(it).toComposeImageBitmap()
                }
                val department = useResource("apartment.png") {
                    ImageIO.read(it).toComposeImageBitmap()
                }
                val report = useResource("lab.png") {
                    ImageIO.read(it).toComposeImageBitmap()
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start, // Adjusted for alignment
                ) {
                    Image(
                        painter = BitmapPainter(imageBitmap),
                        contentDescription = "logo",
                        modifier = Modifier
                            .width(150.dp)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                AccountInfoItem(
                    image = dashboard,
                    label = "Dashboard",
                    isSelected = selectedItem == "Dashboard"
                ) {
                    selectedItem = "Dashboard"
                }
                Spacer(modifier = Modifier.height(12.dp))
                AccountInfoItem(
                    image = groups,
                    label = "Appointment",
                    isSelected = selectedItem == "Appointment"
                ) {
                    selectedItem = "Appointment"
                }
                Spacer(modifier = Modifier.height(12.dp))
                AccountInfoItem(
                    image = person,
                    label = "Patient",
                    isSelected = selectedItem == "Patient" || selectedItem == "patientDetail"
                ) {
                    selectedItem = "Patient"
                }
                Spacer(modifier = Modifier.height(12.dp))
                AccountInfoItem(
                    image = department,
                    label = "Departments",
                    isSelected = selectedItem == "Departments"
                ) {
                    selectedItem = "Departments"
                }
                Spacer(modifier = Modifier.height(12.dp))
                AccountInfoItem(
                    image = report,
                    label = "Reports",
                    isSelected = selectedItem == "Reports"
                ) {
                    selectedItem = "Reports"
                }
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Card(
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                when (selectedItem) {
                    "Dashboard" -> DashboardPage(viewModel)
                    "patientDetail" ->  DetailsPage(viewModel)
                    "Professional Details" -> DashboardPage(viewModel)
                    "Account Security" -> DashboardPage(viewModel)
                    "Payment and Billing" -> DashboardPage(viewModel)

                    else -> DashboardPage(viewModel)
                }
            }
        }
    }
}

