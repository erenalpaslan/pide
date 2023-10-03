package client.pide.view.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import client.pide.view.components.FilledButton
import client.pide.view.components.InfoCard
import client.pide.view.components.Table

/**
 * Created by erenalpaslan on 23.04.2023
 */
@Composable
fun DashboardScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
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
                    Text("Income")
                },
                value = {
                    Text("2,000 ₺")
                }
            )
            Spacer(Modifier.width(24.dp))
            InfoCard(
                modifier = Modifier.weight(1f),
                title = {
                    Text("Expense")
                },
                value = {
                    Text("2,000 ₺")
                }
            )
            Spacer(Modifier.width(24.dp))
        }
        Spacer(Modifier.height(16.dp))
        val cellWidth: (Int) -> Dp = { index ->
            when (index) {
                1 -> 300.dp
                2 -> 150.dp
                else -> 100.dp
            }
        }
        val headerCellTitle: @Composable (Int) -> Unit = { index ->
            val value = when (index) {
                0 -> "#"
                1 -> "Name"
                2 -> "Date"
                3 -> "Type"
                else -> ""
            }

            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Black,
            )
        }
        val cellText: @Composable (Int, Int) -> Unit = { index, o ->
            val value = when (index) {
                0 -> "#1"
                1 -> "Örnek gelir veya gider ismi"
                2 -> "1 May 2023"
                3 -> "Gelir"
                else -> ""
            }

            Text(
                text = value,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }


        Table(
            columnCount = 4,
            cellWidth = cellWidth,
            data = listOf(1,2,3,4,5,6,7),
            modifier = Modifier.verticalScroll(rememberScrollState()),
            headerCellContent = headerCellTitle,
            cellContent = cellText
        )
    }
}