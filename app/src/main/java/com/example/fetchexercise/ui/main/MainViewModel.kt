package com.example.fetchexercise.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchexercise.data.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.net.URL

class MainViewModel : ViewModel() {
    private val mutableState = MutableStateFlow(MainState())
    val state = mutableState.asStateFlow()
    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            // request JSON
            val rawJson = URL("https://hiring.fetch.com/hiring.json").readText()
            val unsortedList = Json.decodeFromString<List<Item>>(rawJson)
            val tmpMap = mutableMapOf<Int, ArrayList<Item>>()

//            ArrayList(unsortedList.sortedWith(
//                compareBy<ListItem> { it.listId }.thenBy { it.name }
//            ).filter { (it.name != null) and (it.name != "") })

            for (i in unsortedList) {
                // ignore items with blank or null name
                if ((i.name != null) and (i.name != "")) {
                    // if list doesn't exist, create empty list
                    if (tmpMap[i.listId] == null) {
                        tmpMap[i.listId] = ArrayList()
                    }
                    // append item to the list
                    tmpMap[i.listId]?.add(i)
                }
            }

            mutableState.value = mutableState.value.copy(
                map = tmpMap.toSortedMap()
            )
        }
    }
}