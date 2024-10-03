package com.example.wishlistapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlistapp.data.Wish

@Composable
fun HomeView(
    navController:NavController,
    viewModel: WishViewModel
){
    Scaffold (
        topBar = { AppBarView(title = "wishlist")},

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all=20.dp),
                contentColor = Color.Red,
                backgroundColor = Color.Red,
                onClick ={
                    navController.navigate(Screen.AddScreen.route)
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    )
        {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)){

        }
    }

}

@Composable
fun WishItem(wish: Wish, onclick: () -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, end = 8.dp)
            .clickable {
                onclick()
            },
            backgroundColor = Color.LightGray,
            elevation = 10.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)){
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text=wish.content, fontWeight = FontWeight.Thin)
        }
    }
}
