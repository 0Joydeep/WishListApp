package com.example.wishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {

    suspend fun addWish(wish: Wish){
        wishDao.addAWish(wish)
    }

    fun getAllWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWish(id: Long): Flow<Wish>{
        return wishDao.getAWishes(id)
    }

    suspend fun updateWish(wish:Wish){
        wishDao.updateAWish(wish)
    }

    suspend fun deleteWish(wish:Wish){
        wishDao.deleteAWish(wish)
    }
}