package com.example.agenda_compose.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.agenda_compose.ui.theme.Purple500

@Composable
fun OutlinedTextFieldCustom(
    value: String,
    onValueChange: (String)->Unit,
    label: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier
){
    OutlinedTextField(
        value,
        onValueChange,
        label = label,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Purple500,
            focusedBorderColor = Purple500
        ),
        modifier = modifier,
        maxLines = 1
    )
}
