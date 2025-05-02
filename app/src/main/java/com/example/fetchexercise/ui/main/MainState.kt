package com.example.fetchexercise.ui.main

import com.example.fetchexercise.data.Item

// MainState holds a map containing the data to be displayed
data class MainState(val map: MutableMap<Int, ArrayList<Item>> = mutableMapOf())
