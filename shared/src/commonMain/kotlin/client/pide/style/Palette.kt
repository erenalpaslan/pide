package client.pide.style

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import client.pide.style.PideColors.azure
import client.pide.style.PideColors.cultured
import client.pide.style.PideColors.white

object PideColors {
    val green = Color(0xFF57BF8E)
    val white = Color(0xFFFFFFFF)
    val black = Color(0xFF212121)
    val gray = Color(0xFFD8DADC)
    val darkGray = Color(0xFF979797)
    val red = Color(0xFFE74E3C)
    val blue = Color(0xFF266EF2)
    val arsenic = Color(0xFF343D46)
    val alabaster = Color(0xFFF4F1E6)
    val gold = Color(0xFFFCB601)
    val pearl = Color(0xFFE9E0CB)
    val outerSpace = Color(0xFF484845)
    val lightRed = Color(0xFFFFD1D1)
    val mistyRose = Color(0xFFFAEFEE)
    val oldLace = Color(0xFFFFF5E4)
    val americanPink = Color(0xFFFF9494)
    val azure = Color(0xFF007aff)
    val cultured = Color(0xFFf7f7f7)
    val raisinBlack = Color(0xFF212121)
    val crayola = Color(0xFF12B76A)
}

@Composable
fun PideTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = azure,
            primaryContainer = azure,
            onPrimaryContainer = white,
            tertiary = cultured,
            secondary = white,
        )
    ) {
        ProvideTextStyle(LocalTextStyle.current.copy(letterSpacing = 0.sp)) {
            content()
        }
    }
}
