package client.pide.style

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import client.pide.style.PideColors.azure
import client.pide.style.PideColors.black
import client.pide.style.PideColors.cultured
import client.pide.style.PideColors.gray200
import client.pide.style.PideColors.slateBlue
import client.pide.style.PideColors.white

object PideColors {
    val green = Color(0xFF57BF8E)
    val white = Color(0xFFFFFFFF)
    val black = Color(0xFF101828)
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
    val slateBlue = Color(0xFF7F56D9)
    val gray700 = Color(0xFF344054)
    val gray200 = Color(0xFFEAECF0)
}

@Composable
fun PideTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = slateBlue,
            onPrimary = white,
            primaryContainer = black,
            onPrimaryContainer = white,
            tertiary = cultured,
            secondary = white,
            outlineVariant = gray200,
            onSurface = slateBlue,
            surfaceVariant = white,
            surface = white
        )
    ) {
        ProvideTextStyle(LocalTextStyle.current.copy(letterSpacing = 0.sp)) {
            content()
        }
    }
}
