package org.example.project.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DashboardCard(label: String, subContent: String, sideContent: String, content: String, image: ImageBitmap, backgroundColor: Color){
    Card(
        modifier = Modifier
            .width(275.dp)
            .height(220.dp)
            .padding(12.dp),
        backgroundColor = backgroundColor,
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp).fillMaxSize()
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)  // Circle size
                        .clip(CircleShape)  // Makes the icon circular
                        .background(Color.White)  // Set background color from list
                        .padding(8.dp),  // Padding inside the circle
                    contentAlignment = Alignment.Center  // Center the text inside the circle
                ) {
                    Image(
                        painter = BitmapPainter(image),
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "${label}",
                    fontSize = 20.sp,
                    color = Color(0xFF222429)

                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "${subContent}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 28.sp,
                    color = Color(0xFF222429)

                )
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier =
                        Modifier
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                    backgroundColor = Color(0xFFF2F2F2),
                    elevation = 2.dp
                ){
                    Text(
                        text = "${sideContent}",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = Color(0xFF2e6930),
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(22.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "${content}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = Color.Gray

                )
            }
        }
    }
}