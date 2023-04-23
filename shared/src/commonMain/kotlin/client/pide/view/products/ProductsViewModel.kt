package client.pide.view.products

import client.pide.data.model.Product
import client.pide.data.model.ProductStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by erenalpaslan on 23.04.2023
 */
class ProductsViewModel {

    private val _uiState: MutableStateFlow<ProductsUiState> = MutableStateFlow(ProductsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update {
            ProductsUiState.ProductListed(
                list = listOf(
                    Product(
                        3034,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.ON_STOCK
                    ),
                    Product(
                        3035,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.UNKNOWN
                    ),
                    Product(
                        3036,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.OUT_OF_STOCK
                    ),
                    Product(
                        3037,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.ON_STOCK
                    ),
                    Product(
                        3038,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.OUT_OF_STOCK
                    ),
                    Product(
                        3030,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.ON_STOCK
                    ),Product(
                        3029,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.ON_STOCK
                    ),Product(
                        3034,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.ON_STOCK
                    ),
                    Product(
                        3034,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.ON_STOCK
                    ),
                    Product(
                        3034,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.ON_STOCK
                    ),
                    Product(
                        3034,
                        "bilezik",
                        "https://picsum.photos/id/237/200/300",
                        "23 April, 2023",
                        ProductStatus.ON_STOCK
                    ),



                )
            )
        }
    }

}