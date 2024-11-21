package am.stylish.app.common_presentation.components.product_list

import am.stylish.app.common_domain.model.Product
import am.stylish.app.common_presentation.components.items.ProductStaggeredGridItem
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ProductListGrid(modifier: Modifier = Modifier, products: List<Product>,onProductClick: (Product) -> Unit = {}) {
    LazyVerticalGrid(
        modifier = modifier.padding(8.dp),
        columns = GridCells.Fixed(2),
    ) {
        items(products) { product ->
            ProductStaggeredGridItem(product){
                onProductClick(product)
            }
        }
    }
}

