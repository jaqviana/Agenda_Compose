package com.example.agenda_compose.views


import android.annotation.SuppressLint
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agenda_compose.R
import com.example.agenda_compose.ui.theme.Purple500
import com.example.agenda_compose.ui.theme.WHITE

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ContactList(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple500,
                contentColor = WHITE,
                title = {
                    androidx.compose.material.Text(text = "Agenda", fontSize = 18.sp)
                }
            )

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("SaveContact")

                },
                backgroundColor = Purple500,
                contentColor = WHITE
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.icc_add_24),
                    contentDescription = "Icon to add a new contact"
                )

            }

        }
    ) {

    }
}

@Preview
@Composable
fun ContactListPreview() {
    ContactList(navController = rememberNavController())
}

