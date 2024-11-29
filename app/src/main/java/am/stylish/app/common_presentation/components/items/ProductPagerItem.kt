package am.stylish.app.common_presentation.components.items

import am.stylish.app.R
import am.stylish.app.common_domain.model.product.Product
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
import androidx.compose.foundation.layout.heightIn
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
fun ProductPagerItem(
    modifier: Modifier = Modifier,
    product: Product,
    onClick: () -> Unit = {},
    onWishlistClick: (String) -> Unit = {}
) {
    Card(
        modifier = modifier
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
                        .clip(Shape10)
                        .heightIn(min = 160.dp, max = 160.dp),
                    model = product.imageUrl,
                    contentDescription = product.name,
                    contentScale = ContentScale.Crop,
                )
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
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
                        val oldPrice = if (product.oldPrice != null) stringResource(
                            R.string.old_price,
                            product.oldPrice
                        )
                        else stringResource(R.string.empty_string)
                        Text(
                            text = oldPrice,
                            style = ProductOldPriceTextStyle,
                        )
                        val discount = if (product.discount != null) stringResource(
                            R.string.off, product.discount
                        )
                        else stringResource(R.string.empty_string)
                        Text(
                            text = discount,
                            style = ProductDiscountTextStyle,
                        )
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
        }
    }
}