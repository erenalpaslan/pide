package client.pide.view.products

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import client.pide.style.PideColors.cultured
import client.pide.style.PideColors.white

/**
 * Created by erenalpaslan on 24.04.2023
 */
@Composable
fun ProductTableHeader(
    onNewProductClicked: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(64.dp)
            .background(white)
            .border(BorderStroke(2.dp, cultured), RoundedCornerShape(8.dp, 8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.width(18.dp))
        Text(
            "#",
            fontWeight = FontWeight.W700,
            modifier = Modifier.defaultMinSize(minWidth = 100.dp),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.width(62.dp))
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Name")
            Text("Status")
        }
        Spacer(Modifier.width(160.dp))
    }
}
