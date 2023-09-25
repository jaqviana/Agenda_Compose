package com.example.agenda_compose.itemlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.agenda_compose.R
import com.example.agenda_compose.ui.theme.ShapeCardView
import com.example.agenda_compose.ui.theme.WHITE

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ItemContact() {

    Card(
        backgroundColor = WHITE,
        contentColor = WHITE,
        elevation = 8.dp,
        shape = ShapeCardView.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp, 10.dp, 10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (txtFirstName, txtEmail, txtPhoneNumber, btnUpdate, btnDelete) = createRefs()

            Text(
                text = "Contact: Ross Galler",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtFirstName){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)


                }
            )

            Text(
                text = "Email: ross@friends.com",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtEmail){
                    top.linkTo(txtFirstName.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)


                }
            )

            Text(
                text = "Phone: 0800123456",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(txtPhoneNumber){
                    top.linkTo(txtEmail.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)


                }
            )

            //img nao tem propriedade de click entao preciso definir um botao e entao colocar uma img
            Button(
                onClick = {

                },
                modifier = Modifier.constrainAs(btnUpdate){
                    start.linkTo(txtPhoneNumber.end, margin = 60.dp)
                    top.linkTo(parent.top, margin = 50.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = WHITE
                ),
                elevation = ButtonDefaults.elevation(
                    disabledElevation = 0.dp,
                    defaultElevation = 0.dp
                )
            ){
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.edit_24) ,
                        contentDescription = "Icon edit"
                    )
                }

            Button(
                onClick = {

                },
                modifier = Modifier.constrainAs(btnDelete){
                    start.linkTo(btnUpdate.end, margin = 2.dp)
                    top.linkTo(parent.top, margin = 50.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = WHITE
                ),
                elevation = ButtonDefaults.elevation(
                    disabledElevation = 0.dp,
                    defaultElevation = 0.dp
                )
            ){
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.delete_24),
                    contentDescription = "Icon delete"
                )
            }

            }
        }

    }






@Preview
@Composable
private fun ItemContactPreview() {
    ItemContact()
}