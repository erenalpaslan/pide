package client.pide.view.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import client.pide.DrawerItem
import client.pide.style.PideColors.white

/**
 * Created by erenalpaslan on 23.04.2023
 */
@Composable
fun PideDrawerContent(
    drawerScreen: MutableState<DrawerItem>,
    onLogoutClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
            .width(200.dp)
            .fillMaxHeight()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Pide v1.0.0", color = white)
        }
        Spacer(Modifier.height(32.dp))
        DrawerItem.values().forEach {item ->
            val selected = item.itemId == drawerScreen.value.itemId
            DrawerItem(
                label = {
                    Text(item.title)
                },
                onClick = {
                    drawerScreen.value = item
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "${item.itemId}",
                        tint = white
                    )
                },
                selected = selected
            )
            Spacer(Modifier.height(4.dp))
        }
        Column(
            modifier = Modifier.fillMaxHeight().weight(1f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Divider()
            Spacer(Modifier.height(12.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column {
                    Text("Jhon Doe", color = white)
                    Text("jhondoe@gmail.com", color = white)
                }
                Spacer(Modifier.width(8.dp))
                IconButton(onClick = onLogoutClicked) {
                    Icon(
                        imageVector = Icons.Rounded.ExitToApp,
                        contentDescription = "Exit",
                        tint = white
                    )
                }
            }
        }
    }
}