import androidx.compose.material.Text
import androidx.compose.runtime.*
import client.pide.BrowserRouter
import client.pide.HashRouter
import client.pide.PideMain
import client.pide.router.Router
import client.pide.view.login.LoginScreen

/**
 * Created by erenalpaslan on 29.04.2023
 */
@Composable
fun PideMainRouter() {
    BrowserRouter("/") {
        route("/") {
            PideMain(this)
        }
        route("/login") {
            LoginScreen()
        }

        noMatch {
            Text("404")
        }
    }
}