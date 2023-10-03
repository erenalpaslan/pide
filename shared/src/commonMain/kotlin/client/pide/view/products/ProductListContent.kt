package client.pide.view.products

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import client.pide.data.model.Product
import client.pide.style.PideColors.cultured
import client.pide.style.PideColors.gray200
import client.pide.style.PideColors.raisinBlack
import client.pide.style.PideColors.red
import client.pide.style.PideColors.white
import client.pide.view.components.Table
import org.jetbrains.skia.Image

/**
 * Created by erenalpaslan on 23.04.2023
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductListContent(list: List<Product>) {
    val cellWidth: (Int) -> Dp = { index ->
        when (index) {
            1 -> 300.dp
            2 -> 150.dp
            else -> 150.dp
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListItem(
    item: Product,
    index: Int,
    onChecked: (Product, Boolean) -> Unit,
) {
    var checked by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (index % 2 == 0) cultured else white)
            .height(44.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
                onChecked(item, it)
            }
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = "#${item.id}",
            fontWeight = FontWeight.W700,
            modifier = Modifier.defaultMinSize(minWidth = 100.dp),
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(Modifier.width(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = item.name, overflow = TextOverflow.Ellipsis)
            Column(
                modifier = Modifier.width(120.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .border(BorderStroke(1.dp, item.status.color), RoundedCornerShape(50.dp))
                ) {
                    Text(
                        text = item.status.status,
                        style = MaterialTheme.typography.labelSmall,
                        color = item.status.color,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
        }
        Spacer(Modifier.width(16.dp))
        IconButton(onClick = {

        }) {
            Icon(
                imageVector = Icons.Rounded.Edit,
                contentDescription = "Edit",
                tint = MaterialTheme.colorScheme.primary
            )
        }
        IconButton(onClick = {

        }
        ) {
            Icon(
                imageVector = Icons.Rounded.Delete,
                contentDescription = "Remove",
                tint = red
            )
        }
        Spacer(Modifier.width(16.dp))
    }
}