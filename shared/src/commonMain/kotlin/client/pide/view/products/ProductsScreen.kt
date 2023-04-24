package client.pide.view.products

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*

/**
 * Created by erenalpaslan on 23.04.2023
 */
@Composable
fun ProductsScreen(viewModel: ProductsViewModel = ProductsViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val newProductDialogState = remember {
        mutableStateOf(false)
    }

    Column {
        ProductTableHeader(
            onNewProductClicked = {
                newProductDialogState.value = true
            }
        )
        when (uiState) {
            ProductsUiState.EmptyList -> ProductEmptyListContent()
            ProductsUiState.Loading -> {}
            is ProductsUiState.ProductListed -> ProductListContent((uiState as ProductsUiState.ProductListed).list)
        }
    }

    NewProductDialog(
        show = newProductDialogState
    ) {

    }
}