package client.pide.view.products

import client.pide.data.model.Product

/**
 * Created by erenalpaslan on 23.04.2023
 */
sealed interface ProductsUiState {

    object Loading: ProductsUiState

    data class ProductListed(
        val list: List<Product> = emptyList()
    ): ProductsUiState

    object EmptyList: ProductsUiState

}