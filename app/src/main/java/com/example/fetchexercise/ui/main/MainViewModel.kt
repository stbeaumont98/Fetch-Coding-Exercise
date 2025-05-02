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
            // parse JSON data into a list of our data class items, filtering
            // any items with a blank or null name property
            val jsonList = Json.decodeFromString<List<Item>>(rawJson)
                .filter { (it.name != null) and (it.name != "") }
            //    .sortedWith( compareBy<Item> { it.listId }.thenBy { it.name } )
            // if I wasn't using a map to subdivide each list for display,
            // line 23 could be uncommented and used to sort the list in the requested order

            val tmpMap = mutableMapOf<Int, ArrayList<Item>>()

            // iterate through the list
            for (i in jsonList) {
                // if a list doesn't exist at the specified key, initialize empty list
                if (tmpMap[i.listId] == null) {
                    tmpMap[i.listId] = ArrayList()
                }
                // append item to the list at the specified key
                tmpMap[i.listId]?.add(i)
            }

            mutableState.value = mutableState.value.copy(
                map = tmpMap.toSortedMap()
            )
        }
    }
}