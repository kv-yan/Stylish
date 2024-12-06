package am.stylish.app.common_presentation.components.product_list

import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.components.items.ProductStaggeredGridItem
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ProductListStaggeredGrid(
    modifier: Modifier = Modifier,
    products: List<Product>,
    onProductClick: (Product) -> Unit = {}
) {
    val rows = products.size
    val maxHeight = (rows) * 400
    LazyVerticalStaggeredGrid(
        modifier = modifier
            .padding(8.dp)
            .heightIn(
                min = 0.dp,
                max = maxHeight.dp
            ),
        columns = StaggeredGridCells.Fixed(2),
    ) {
        items(products, key = { it.id }) { product ->
            ProductStaggeredGridItem(product) {
                onProductClick(product)
            }
        }
    }
}

