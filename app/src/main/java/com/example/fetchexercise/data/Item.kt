package com.example.fetchexercise.data

import kotlinx.serialization.Serializable

@Serializable
data class Item(var id: Int, var listId: Int, var name: String?)
