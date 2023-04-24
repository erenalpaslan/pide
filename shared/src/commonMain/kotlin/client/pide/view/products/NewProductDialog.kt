package client.pide.view.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import client.pide.data.model.Product
import client.pide.data.model.ProductStatus
import client.pide.style.PideColors.black

/**
 * Created by erenalpaslan on 24.04.2023
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewProductDialog(
    show: MutableState<Boolean>,
    onAddClicked: (Product) -> Unit
) {
    var id by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var availability by remember {
        mutableStateOf(0)
    }

    if (show.value) {
        Surface(
            color = black.copy(alpha = 0.3f),
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Card(
                    shape = RoundedCornerShape(32.dp),
                    modifier = Modifier.fillMaxWidth(0.6f)
                        .fillMaxHeight(0.8f)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("New Product")
                        Spacer(Modifier.height(16.dp))
                        OutlinedTextField(
                            value = id,
                            onValueChange = {
                                id = it
                            },
                            placeholder = {
                                Text("Enter product id")
                            }
                        )
                        Spacer(Modifier.height(16.dp))
                        OutlinedTextField(
                            value = name,
                            onValueChange = {
                                name = it
                            },
                            placeholder = {
                                Text("Enter product name")
                            }
                        )
                        Spacer(Modifier.height(16.dp))
                        Row {
                            FilterChip(
                                onClick = {
                                    availability = 0
                                },
                                colors = FilterChipDefaults.filterChipColors(
                                    disabledContainerColor = ProductStatus.ON_STOCK.color.copy(alpha = 0.2f)
                                ),
                                selected = availability == 0,
                                label = {
                                    Text(
                                        text = ProductStatus.ON_STOCK.status,
                                        style = MaterialTheme.typography.labelMedium,
                                        color = ProductStatus.ON_STOCK.color
                                    )
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = ProductStatus.ON_STOCK.icon,
                                        contentDescription = "",
                                        tint = ProductStatus.ON_STOCK.color
                                    )
                                }
                            )
                            Spacer(Modifier.width(8.dp))
                            FilterChip(
                                onClick = {
                                    availability = 1
                                },
                                colors = FilterChipDefaults.filterChipColors(
                                    disabledContainerColor = ProductStatus.UNKNOWN.color.copy(alpha = 0.2f)
                                ),
                                selected = availability == 1,
                                label = {
                                    Text(
                                        text = ProductStatus.UNKNOWN.status,
                                        style = MaterialTheme.typography.labelMedium,
                                        color = ProductStatus.UNKNOWN.color
                                    )
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = ProductStatus.UNKNOWN.icon,
                                        contentDescription = "",
                                        tint = ProductStatus.UNKNOWN.color
                                    )
                                }
                            )
                            Spacer(Modifier.width(8.dp))
                            FilterChip(
                                onClick = {
                                    availability = 2
                                },
                                colors = FilterChipDefaults.filterChipColors(
                                    disabledContainerColor = ProductStatus.OUT_OF_STOCK.color.copy(alpha = 0.2f)
                                ),
                                selected = availability == 2,
                                label = {
                                    Text(
                                        text = ProductStatus.OUT_OF_STOCK.status,
                                        style = MaterialTheme.typography.labelMedium,
                                        color = ProductStatus.OUT_OF_STOCK.color
                                    )
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = ProductStatus.OUT_OF_STOCK.icon,
                                        contentDescription = "",
                                        tint = ProductStatus.OUT_OF_STOCK.color
                                    )
                                }
                            )
                        }
                        Spacer(Modifier.height(32.dp))
                        Button(
                            onClick = {
                                show.value = false
                                onAddClicked(
                                    Product(
                                        id = id,
                                        name = name,
                                        imageUrl = "",
                                        createdAt = "",
                                        status = ProductStatus.values().firstOrNull { it.ordinal == availability } ?: ProductStatus.UNKNOWN
                                    )
                                )
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Add")
                        }
                    }
                }
            }
        }
    }
}