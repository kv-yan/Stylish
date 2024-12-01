package am.stylish.app.common_presentation.components.product_list

import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.components.items.ProductPagerItem
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ProductListGrid(
    modifier: Modifier = Modifier,
    products: List<Product>,
    onProductClick: (Product) -> Unit = {}
) {

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
    ) {
        items(products) { product ->
            ProductPagerItem(product = product) {
                onProductClick(product)
            }
        }
    }
}

