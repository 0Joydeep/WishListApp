package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
):ViewModel() {
    var wishTitleState by  mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString: String){
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String){
        wishDescriptionState = newString
    }

    // lateinit helps with late initialisation of varibles
    // often used with variables concerning coroutines and stuff pretty sleek
    // cannot be used with val or primitive datatypes
    lateinit var getAllWishes: Flow<List<Wish>>

    init{
        viewModelScope.launch{
            getAllWishes = wishRepository.getAllWishes()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.addWish(wish)
        }
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.updateWish(wish)
        }
     }

    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.deleteWish(wish)
        }
    }

    fun getAWish(id:Long):Flow<Wish>{
        return wishRepository.getAWish(id)
    }

}