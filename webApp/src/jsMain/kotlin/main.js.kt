import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import client.pide.PideMain
import client.pide.style.PideTheme

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
