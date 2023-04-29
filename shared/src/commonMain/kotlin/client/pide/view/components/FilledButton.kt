package client.pide.view.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by erenalpaslan on 29.04.2023
 */
@Composable
fun FilledButton(
    onCLicked: () -> Unit,
    text: String? = null,
    icon: @Composable () -> Unit = {}
) {
    Button(
        onClick = {
            onCLicked()
        },
        shape = MaterialTheme.shapes.small
    ) {
        icon()
        if (!text.isNullOrEmpty()) {
            Spacer(Modifier.width(4.dp))
            Text(text)
        }
    }
}