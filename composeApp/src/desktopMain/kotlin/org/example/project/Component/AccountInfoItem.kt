package org.example.project.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AccountInfoItem(image: ImageBitmap, label: String, isSelected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth().height(75.dp).clip(RoundedCornerShape(8.dp))
            .background(color = if (isSelected) Color(0xFFD6E7EE) else Color.White) // Dynamic background color
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable { onClick() }, // Padding inside the Row
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start, // Adjusted for alignment
    ) {

        Image(
            painter = BitmapPainter(image),
            contentDescription = "image",
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .padding(end = 8.dp)
        )
        Text(
            text = label,
            fontSize = 16.sp,
            color = if (isSelected) Color(0xFF222429) else Color(0xFF808088),
            modifier = Modifier.padding(start = 8.dp) // Padding around the Text
        )
    }
}