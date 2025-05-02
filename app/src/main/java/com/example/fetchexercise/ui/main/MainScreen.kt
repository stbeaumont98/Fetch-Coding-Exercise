package com.example.fetchexercise.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchexercise.data.Item
import com.example.fetchexercise.ui.listitems.ListItem

@Composable
fun MainScreen(state: MainState) {
    Surface(modifier = Modifier
        .padding(top = 24.dp)
        .fillMaxSize()) {
        LazyColumn {
            state.map.forEach { (listId, list) ->
                // listId label
                stickyHeader {
                    Surface(modifier = Modifier
                        .fillMaxWidth()) {
                        Text(modifier = Modifier
                                .padding(vertical = 12.dp)
                                .padding(start = 12.dp),
                            text = "listId: $listId",
                            fontSize = 32.sp)
                    }
                }

                // Sorting by "name" produces results in non-numerical order.
                // For example, a list might appear in the following order:
                // [Item 1, Item 101, Item 12, Item 2, Item 291, Item 3, Item 31]
                // Since the number in the name corresponds to its id, I've opted
                // to sort by id; however, you could easily change "it.id" in the
                // line below to "it.name" if the list needs to be sorted
                // alphabetically (or the previously described behavior is desired).
                items(list.sortedBy { it.id }) { i ->
                    ListItem(i)
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen(
            state = MainState(
                map = mutableMapOf(
                    1 to arrayListOf(Item(1, 1, "Item 1")),
                    2 to arrayListOf(Item(2, 2, "Item 2"), Item(3, 2, "Item 3")),
                    )
            )
        )
    }
}