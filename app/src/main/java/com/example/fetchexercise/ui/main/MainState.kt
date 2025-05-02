package com.example.fetchexercise.ui.main

import com.example.fetchexercise.data.Item

data class MainState(val map: MutableMap<Int, ArrayList<Item>> = mutableMapOf())
