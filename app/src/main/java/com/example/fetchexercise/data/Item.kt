package com.example.fetchexercise.data

import kotlinx.serialization.Serializable

// A simple data class using the Serializable plugin for parsing JSON data.
@Serializable
data class Item(var id: Int, var listId: Int, var name: String?)
