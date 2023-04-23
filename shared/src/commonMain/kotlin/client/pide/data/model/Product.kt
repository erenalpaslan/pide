package client.pide.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import client.pide.style.PideColors.azure
import client.pide.style.PideColors.crayola
import client.pide.style.PideColors.raisinBlack
import client.pide.style.PideColors.red

/**
 * Created by erenalpaslan on 23.04.2023
 */
data class Product(
    val id: Int,
    val name: String,
    val imageUrl: String = "",
    val createdAt: String?,
    val status: ProductStatus
)

enum class ProductStatus(
    val status: String,
    val color: Color,
    val icon: ImageVector
) {
    ON_STOCK(
        status = "On stock",
        color = crayola,
        icon = Icons.Rounded.Done
    ),
    UNKNOWN(
        status = "Unknown",
        color = raisinBlack,
        icon = Icons.Rounded.Remove
    ),
    OUT_OF_STOCK(
        status = "Out of stock",
        color = red,
        icon = Icons.Rounded.Close
    )
}
