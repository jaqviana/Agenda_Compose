package com.example.agenda_compose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agenda_compose.ui.theme.Purple500
import com.example.agenda_compose.ui.theme.WHITE
import androidx.compose.material.Button

@Composable
fun ButtonCustom(
    onClick: () -> Unit,
    text: String){
    Button(
      onClick
        ,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple500
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = text, fontSize = 18.sp, color = WHITE)
    }
}