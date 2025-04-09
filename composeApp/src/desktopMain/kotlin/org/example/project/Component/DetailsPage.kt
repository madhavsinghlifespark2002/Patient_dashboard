package org.example.project.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
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
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.ApiService.ApiService
import org.example.project.Resourcem
import org.example.project.data.FhirBundle
import org.example.project.viewmodels.SharedViewModel
import javax.imageio.ImageIO

@Composable
fun DetailsPage(viewModel: SharedViewModel){
    val repository = ApiService()
    var patientData by remember { mutableStateOf<Resourcem?>(null) }
    suspend fun fetchPatientsbyId() {
        patientData = repository.fetchPatientsbyId(viewModel.patientId.value)
    }
    LaunchedEffect(Unit) {
        fetchPatientsbyId()
    }
    val imageBitmap = useResource("forward.png") {
        ImageIO.read(it).toComposeImageBitmap()
    }
    val imageBitmap2 = useResource("doctorReal2.png") {
        ImageIO.read(it).toComposeImageBitmap()
    }
    Text(text = "Patient", fontSize = 22.sp, color = Color(0xff202020) )
    Spacer(modifier = Modifier.height(12.dp))
    Divider()
    Spacer(modifier = Modifier.height(12.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "Patient List", fontSize = 14.sp, color = Color(0xff909090) )
        Spacer(modifier = Modifier.width(12.dp))
        Image(
            painter = BitmapPainter(imageBitmap),
            contentDescription = "logo",
//            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = "Patient detail", fontSize = 14.sp, color = Color(0xff105749) )

    }
    Spacer(modifier = Modifier.height(12.dp))
    Divider()
    Spacer(modifier = Modifier.height(12.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = BitmapPainter(imageBitmap2),
            contentDescription = "avator",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(70.dp).clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = patientData?.name?.firstOrNull { it.use == "official" }
            ?.let { it.given.joinToString(" ") } ?: "N/A", fontSize = 20.sp, color = Color(0xff202020) )
    }
    HorizontalTabsDemo(patientData)
}
