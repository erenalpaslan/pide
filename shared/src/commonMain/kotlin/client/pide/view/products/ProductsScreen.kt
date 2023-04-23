package client.pide.view.products

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

/**
 * Created by erenalpaslan on 23.04.2023
 */
@Composable
fun ProductsScreen(viewModel: ProductsViewModel = ProductsViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        ProductsUiState.EmptyList -> ProductEmptyListContent()
        ProductsUiState.Loading -> {}
        is ProductsUiState.ProductListed -> ProductListContent((uiState as ProductsUiState.ProductListed).list)
    }
}