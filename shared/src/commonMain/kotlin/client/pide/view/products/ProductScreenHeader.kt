package client.pide.view.products

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import client.pide.view.components.FilledButton

/**
 * Created by erenalpaslan on 29.04.2023
 */
@Composable
fun ProductScreenHeader(
    onNewClicked: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("Products", style = MaterialTheme.typography.titleLarge)
            Text("Keep track your products in here!")
        }
        FilledButton(
            onCLicked = {
                onNewClicked()
            },
            text = "Add Product",
            icon = {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add")
            }
        )
    }
    Divider()
}