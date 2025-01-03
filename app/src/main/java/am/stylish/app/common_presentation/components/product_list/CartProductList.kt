package am.stylish.app.common_presentation.components.product_list

import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.components.items.CartProductItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CartProductList(
    modifier: Modifier = Modifier,
    products: List<Product>,
    onDeleteClick: (String) -> Unit = {},
    onProductClick: (Product) -> Unit = {}
) {
    val columns = products.size
    val maxHeight = columns * 258

    LazyColumn(
        modifier = modifier.heightIn(min = 0.dp, max = maxHeight.dp),
        userScrollEnabled = false,
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        items(
            items = products,
            key = { it.id }
        ) { product ->
            Box(
                modifier = Modifier
                    .animateItem(fadeInSpec = null, fadeOutSpec = null)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                CartProductItem(
                    product = product,
                    onDeleteClick = { onDeleteClick(product.id) },
                    onProductClick = { onProductClick(product) }
                )
            }
        }
    }
}
