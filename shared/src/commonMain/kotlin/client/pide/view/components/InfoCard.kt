package client.pide.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by erenalpaslan on 30.04.2023
 */
@Composable
fun InfoCard(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    value: @Composable () -> Unit,
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth()
            .defaultMinSize(minHeight = 120.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Nisan 2023", style = MaterialTheme.typography.labelSmall)
                    Spacer(Modifier.height(4.dp))
                    title()
                }
                IconButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "more")
                }
            }
            Spacer(Modifier.height(8.dp))
            value()
        }
    }
}
