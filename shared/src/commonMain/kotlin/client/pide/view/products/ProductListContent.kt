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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import client.pide.data.model.Product
import client.pide.style.PideColors.cultured
import client.pide.style.PideColors.raisinBlack
import client.pide.style.PideColors.red
import client.pide.style.PideColors.white
import org.jetbrains.skia.Image

/**
 * Created by erenalpaslan on 23.04.2023
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductListContent(list: List<Product>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
    ) {
        itemsIndexed(list) { index, item ->
            ProductListItem(item, index) { _, _ ->

            }
        }
    }
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
            FilterChip(
                onClick = {},
                colors = FilterChipDefaults.filterChipColors(
                    disabledContainerColor = item.status.color.copy(alpha = 0.2f)
                ),
                selected = false,
                label = {
                    Text(
                        text = item.status.status,
                        style = MaterialTheme.typography.labelMedium,
                        color = item.status.color
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = item.status.icon,
                        contentDescription = "",
                        tint = item.status.color
                    )
                },
                enabled = false
            )
        }
        Spacer(Modifier.width(90.dp))
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