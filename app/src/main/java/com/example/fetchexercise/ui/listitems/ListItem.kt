package com.example.fetchexercise.ui.listitems

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchexercise.data.Item
import com.example.fetchexercise.ui.theme.FetchExerciseTheme

// Each list item displays it's id, then it's name
// Since the listId appears above each list, I've opted to
// omit that from each individual item

@Composable
fun ListItem(item: Item) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()) {
            // display the item id
            Text(modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                text = "${item.id}",
                color = Color.Gray)
            // display the item name
            Text(modifier = Modifier
                    .padding(8.dp),
                text = "${item.name}",
                fontSize = 24.sp)
        }
    }
}

@Preview
@Composable
fun ListItemPreview() {
    FetchExerciseTheme {
        ListItem(Item(12, 1, "Item 12"))
    }
}