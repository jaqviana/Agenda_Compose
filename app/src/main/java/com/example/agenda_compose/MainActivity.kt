package com.example.agenda_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agenda_compose.ui.theme.Agenda_ComposeTheme
import com.example.agenda_compose.views.ContactList
import com.example.agenda_compose.views.SaveContact
import com.example.agenda_compose.views.UpdateContact


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           //Agenda_ComposeTheme {

               val navController = rememberNavController()

                NavHost(
                    navController = navController, startDestination = "ContactList") { //primeira tela
                    composable("ContactList") {
                        ContactList(navController)
                    }

                    composable("SaveContact") {
                        SaveContact(navController)
                    }
                    composable("UpdateContact/(uid)") {
                        UpdateContact(navController)
                    }
                }
           //}
        }
    }
}


