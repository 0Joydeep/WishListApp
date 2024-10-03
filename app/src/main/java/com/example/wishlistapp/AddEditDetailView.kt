package com.example.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddEditDetailView(
    id: Long,
    viewmodel: WishViewModel,
    navController: NavController
){
    Scaffold (
        topBar = {
            AppBarView(title = if(id != 0L){"Update Wish"}else{"Add Wish"})
            {navController.navigateUp()}
        }
    ){
        Column(modifier = Modifier
            .padding(it)
            .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(label = "Title", value = viewmodel.wishTitleState,
                onValueChanged = {viewmodel.onWishTitleChanged(it)})

            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(label = "Description", value = viewmodel.wishDescriptionState,
                onValueChanged = {viewmodel.onWishDescriptionChanged(it)})

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {}){
                Text(
                    text = if (id != 0L) {
                        "Update Wish"
                    } else {
                        "Add Wish"
                    },
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        }
    }
}


@Composable
fun WishTextField(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = label, color = Color.Black) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.LightGray,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.LightGray,
            cursorColor = Color.Black
        )
    )
}
