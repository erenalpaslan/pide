package client.pide.view.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import client.pide.style.PideColors.azure
import client.pide.style.PideColors.cultured

/**
 * Created by erenalpaslan on 23.04.2023
 */
@Composable
fun DrawerItem(
    label: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    selected: Boolean = false,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected)
                azure
            else
                cultured
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            icon()
            Spacer(Modifier.width(4.dp))
            label()
        }
    }
}