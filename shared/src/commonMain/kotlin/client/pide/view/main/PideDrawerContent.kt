package client.pide.view.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import client.pide.DrawerItem
import client.pide.style.PideColors.black
import client.pide.style.PideColors.cultured
import client.pide.style.PideColors.white

/**
 * Created by erenalpaslan on 23.04.2023
 */
@Composable
fun PideDrawerContent(
    drawerScreen: MutableState<DrawerItem>
) {
    Column(
        modifier = Modifier
            .background(cultured)
            .padding(16.dp)
            .width(200.dp)
            .fillMaxHeight()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Pide v1.0.0")
        }
        Spacer(Modifier.height(32.dp))
        DrawerItem.values().forEach {item ->
            val selected = item.itemId == drawerScreen.value.itemId
            DrawerItem(
                label = {
                    Text(item.title, color = if (selected) white else black)
                },
                onClick = {
                    drawerScreen.value = item
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "${item.itemId}",
                        tint = if (selected) white else black
                    )
                },
                selected = selected
            )
            Spacer(Modifier.height(4.dp))
        }
    }
}