package am.stylish.app.common_presentation.components.items

import am.stylish.app.R
import am.stylish.app.common_domain.entity.CartItem
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.components.button.AddToCartButton
import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.ui.theme.ProductDescriptionTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductDiscountTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductOldPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductReviewQuantityTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.Shape10
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProductStaggeredGridItem(
    product: Product,
    onClick: () -> Unit = {},
    onWishlistClick: (String) -> Unit = {},
    onAddToCart: (String, Int) -> Unit = { _, _ -> },
    onRemoveFromCart: (String, Int) -> Unit = { _, _ -> },
    isItemInCart: (String) -> CartItem? = { null }
) {
    val isInCart = isItemInCart(product.id)
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = Shape10,
        onClick = onClick
    ) {
        Box {
            Column {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(Shape10),
                    model = product.imageUrl,
                    contentDescription = product.name,
                    contentScale = ContentScale.Crop,
                )
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Text(
                        text = product.name,
                        style = ProductTitleTextStyle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = product.description,
                        style = ProductDescriptionTextStyle,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = stringResource(R.string.price, product.price),
                        style = ProductPriceTextStyle,
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        product.oldPrice?.let {
                            Text(
                                text = stringResource(R.string.old_price, it),
                                style = ProductOldPriceTextStyle,
                            )
                        }
                        product.discount?.let {
                            Text(
                                text = stringResource(R.string.off, it),
                                style = ProductDiscountTextStyle,
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        RatingBar(rating = product.rating)
                        product.reviewsCount?.let {
                            Text(
                                text = it.toString(),
                                style = ProductReviewQuantityTextStyle,
                            )
                        }
                    }
                }
            }

            IconButton(
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = { onWishlistClick(product.id) },
                colors = IconButtonDefaults.iconButtonColors(containerColor = CoolGray.copy(0.3f))
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_favorite_outline),
                    contentDescription = null,
                    tint = Color.Black
                )
            }

            AddToCartButton(
                modifier = Modifier.align(Alignment.BottomEnd),
                isAdded = isInCart != null,
                quantity = isInCart?.quantity ?: 0
            ) {
                onAddToCart(product.id, 1)
            }
        }
    }
}