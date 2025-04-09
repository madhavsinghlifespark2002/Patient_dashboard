package org.example.project.Component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuestionAnswer(question: String, answer: String){
    Column{
        Text(text = question, fontSize = 14.sp, color = Color(0xff909090))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = answer, fontSize = 16.sp, color = Color(0xff202020))
    }
}