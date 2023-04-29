import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import androidx.compose.ui.window.Window
import client.pide.PideMain
import client.pide.style.PideTheme
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(
        title = "Pide",
    ) {
        PideTheme {
            PideMain()
        }
    }
}
