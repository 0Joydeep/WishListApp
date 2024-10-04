package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "WishTable")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0L,
    @ColumnInfo(name = "WIsh_Title")
    val title: String="",
    @ColumnInfo(name = "Wish_Desc")
    val content: String=""
)
