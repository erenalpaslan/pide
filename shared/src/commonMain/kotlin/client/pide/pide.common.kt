package client.pide

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import client.pide.view.dashboard.DashboardScreen
import client.pide.view.main.PideDrawerContent
import client.pide.view.products.ProductsScreen
import client.pide.view.reports.ReportsScreen
import client.pide.view.settings.SettingsScreen

enum class ExternalImageViewerEvent {
    Foward,
    Back
}

enum class DrawerItem(
    val itemId: Int,
    val title: String,
    val icon: ImageVector
) {
    DASHBOARD(0, "Dashboard", Icons.Rounded.Category),
    PRODUCTS(1, "Products", Icons.Rounded.Storefront),
    REPORTS(2, "Reports", Icons.Rounded.Description),
    SETTINGS(4, "Settings", Icons.Rounded.Settings),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PideMain() {
    val drawerScreen = remember {
        mutableStateOf(DrawerItem.DASHBOARD)
    }

    PermanentNavigationDrawer(
        drawerContent = {
            PideDrawerContent(
                drawerScreen = drawerScreen
            )
        }
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            when(drawerScreen.value) {
                DrawerItem.PRODUCTS -> ProductsScreen()
                DrawerItem.REPORTS -> ReportsScreen()
                DrawerItem.SETTINGS -> SettingsScreen()
                else -> DashboardScreen()
            }
        }
    }
}
