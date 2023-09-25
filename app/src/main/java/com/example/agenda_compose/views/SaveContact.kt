package com.example.agenda_compose.views

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agenda_compose.AppDatabase
import com.example.agenda_compose.components.ButtonCustom
import com.example.agenda_compose.components.OutlinedTextFieldCustom
import com.example.agenda_compose.dao.ContactDao
import com.example.agenda_compose.model.Contact
import com.example.agenda_compose.ui.theme.Purple500
import com.example.agenda_compose.ui.theme.WHITE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var contactDao: ContactDao //para pegar os metodos listados no Dao

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SaveContact(navController: NavController) {

    val listContact: MutableList<Contact> = mutableListOf()
    val scope = rememberCoroutineScope()//Room database funciona em uma thread separada

    val context = LocalContext.current

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple500,
                contentColor = WHITE,
                title = {
                    Text(
                        text = "Save new contact", fontSize = 18.sp
                    )

                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextFieldCustom(
                value = firstName,
                onValueChange = {
                    firstName = it
                },
                label = {
                    Text(text = "First Name")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 80.dp, 20.dp, 10.dp)
            )

            OutlinedTextFieldCustom(
                value = lastName,
                onValueChange = {
                    lastName = it //name vai receber o q for digitado
                },
                label = {
                    Text(text = "Last name")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp)
            )

            OutlinedTextFieldCustom(
                value = email,
                onValueChange = {
                    email = it //name vai receber o q for digitado
                },
                label = {
                    Text(text = "Email")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp),

                )
            OutlinedTextFieldCustom(
                value = phoneNumber,
                onValueChange = {
                    phoneNumber = it //name vai receber o q for digitado
                },
                label = {
                    Text(text = "Phone Number")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 10.dp),
            )

            ButtonCustom(
                onClick = {

                    var message = false
                    //thread paralela

                    scope.launch(Dispatchers.IO) {
                        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
                            message = false
                        } else {
                          message = true
                            val contact = Contact(firstName, lastName, email, phoneNumber)
                            listContact.add(contact) //salvando os dados para  a lista de contatos
                            contactDao = AppDatabase.getInstance(context)
                                .contactDao() //banco de dados iniciado
                            contactDao.save(listContact)
                        }
                    }

                    //thread principal (o q mostra para o usuario)
                    scope.launch(Dispatchers.Main) {
                        if (message) {
                            Toast.makeText(
                                context,
                                "Contact saved successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                            navController.popBackStack()
                        }else{
                            Toast.makeText(
                                context,
                                "Fill in all fields",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                },
                text = "Save"
            )

        }
    }

}

//ver filds formatcao ta diferente os padding nao estao mudando
//tbm nao estou conseguindo ver no logcat as msg









