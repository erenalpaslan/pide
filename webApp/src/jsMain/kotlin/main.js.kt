import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import client.pide.style.PideTheme
import kotlinx.coroutines.delay
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow(
            title = "Pide",
        ) {
            PideTheme {
                PideMainRouter()
            }
        }
    }
}
