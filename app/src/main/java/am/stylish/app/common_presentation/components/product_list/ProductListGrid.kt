package am.stylish.app.common_presentation.components.product_list

import am.stylish.app.common_domain.entity.CartItem
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
    onProductClick: (Product) -> Unit = {},
    onWishlistClick: (String) -> Unit = {},
    onCartClick: (String) -> Unit = {},
    onAddToCart: (String, Int) -> Unit = { _, _ -> },
    onRemoveFromCart: (String, Int) -> Unit = { _, _ -> },
    isItemInCart: (String) -> CartItem? = { null }
) {

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
    ) {
        items(products, key = { it.id }) { product ->
            ProductPagerItem(
                product = product,
                onClick = {
                    onProductClick(product)
                },
                onWishlistClick = {
                    onWishlistClick(it)
                },
                onCartClick = {
                    onCartClick(it)
                },
                onAddToCart = { id, quantity ->
                    onAddToCart(id, quantity)
                },
                onRemoveFromCart = { id, quantity ->
                    onRemoveFromCart(id, quantity)
                },
                isItemInCart = isItemInCart
            )
        }
    }
}

