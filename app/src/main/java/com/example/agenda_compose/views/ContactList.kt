package com.example.agenda_compose.views


import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agenda_compose.AppDatabase
import com.example.agenda_compose.R
import com.example.agenda_compose.dao.ContactDao
import com.example.agenda_compose.itemlist.ItemContact
import com.example.agenda_compose.model.Contact
import com.example.agenda_compose.ui.theme.Purple500
import com.example.agenda_compose.ui.theme.WHITE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
private  lateinit var contactDao: ContactDao
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun ContactList(navController: NavController) {

    val context = LocalContext.current
    val listContact: MutableList<Contact> = mutableListOf()

    //abrir uma nova thread para recuperar os dados do vanco de dados
    val scope = rememberCoroutineScope()

    scope.launch(Dispatchers.IO){
        contactDao = AppDatabase.getInstance(context).contactDao()
        val contact = contactDao.getContact()

        //quebrar a lista e passar para a lista de contatos

        for (contact in contact){
            listContact.add(contact)
        }

    }
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

        LazyColumn{
            itemsIndexed(listContact){position, item ->
                ItemContact(navController, position, listContact, context)

            }
        }

    }
}

@Preview
@Composable
fun ContactListPreview() {
    ContactList(navController = rememberNavController())
}

