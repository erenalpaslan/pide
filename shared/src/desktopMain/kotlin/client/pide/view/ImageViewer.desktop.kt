package client.pide.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.*
import client.pide.ExternalImageViewerEvent
import client.pide.style.PideTheme
import example.imageviewer.*
import example.imageviewer.model.*
import example.imageviewer.utils.ioDispatcher
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class ExternalNavigationEventBus {
    private val _events = MutableSharedFlow<ExternalImageViewerEvent>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    val events = _events.asSharedFlow()

    fun produceEvent(event: ExternalImageViewerEvent) {
        _events.tryEmit(event)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ApplicationScope.ImageViewerDesktop() {
    val ioScope: CoroutineScope = rememberCoroutineScope { ioDispatcher }
    val externalNavigationEventBus = remember { ExternalNavigationEventBus() }

    Window(
        onCloseRequest = ::exitApplication,
        title = "Image Viewer",
        icon = painterResource("ic_imageviewer_round.png"),
        // https://github.com/JetBrains/compose-jb/issues/2741
        onKeyEvent = {
            if (it.type == KeyEventType.KeyUp) {
                when (it.key) {
                    Key.DirectionLeft -> externalNavigationEventBus.produceEvent(
                        ExternalImageViewerEvent.Back
                    )

                    Key.DirectionRight -> externalNavigationEventBus.produceEvent(
                        ExternalImageViewerEvent.Foward
                    )
                }
            }
            false
        }
    ) {
        PideTheme {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Text("Hello world")
            }
        }
    }
}