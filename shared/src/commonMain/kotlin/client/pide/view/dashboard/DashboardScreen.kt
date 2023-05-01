package client.pide.view.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import client.pide.view.components.FilledButton
import client.pide.view.components.InfoCard

/**
 * Created by erenalpaslan on 23.04.2023
 */
@Composable
fun DashboardScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Activity overview", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(4.dp))
                Text("Track, manage and forecast your activities.")
            }
            FilledButton(
                onCLicked = {

                },
                text = "Add",
                icon = {
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add")
                }
            )
        }
        Spacer(Modifier.height(32.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            InfoCard(
                modifier = Modifier.weight(1f),
                title = {
                    Text("Total activity")
                },
                value = {
                    Text("2,000 ₺")
                }
            )
            Spacer(Modifier.width(24.dp))
            InfoCard(
                modifier = Modifier.weight(1f),
                title = {
                    Text("Total income")
                },
                value = {
                    Text("2,000 ₺")
                }
            )
            Spacer(Modifier.width(24.dp))
            InfoCard(
                modifier = Modifier.weight(1f),
                title = {
                    Text("Total expense")
                },
                value = {
                    Text("2,000 ₺")
                }
            )
            Spacer(Modifier.width(24.dp))
        }
    }
}