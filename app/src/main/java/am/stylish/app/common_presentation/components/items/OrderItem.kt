package am.stylish.app.common_presentation.components.items

import am.stylish.app.R
import am.stylish.app.common_presentation.components.checkbox.AppCheckBox
import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.ui.theme.ProductOldPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.common_presentation.ui.theme.Shape4
import am.stylish.app.order_details_screen.domain.model.OrderItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun OrderItem(
    modifier: Modifier = Modifier,
    orderItem: OrderItem,
    onCheckedChange: (OrderItem) -> Unit = {},
    onDeleteClick: (OrderItem) -> Unit = {}
) {
    val product = orderItem.product
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AppCheckBox(checked = orderItem.isSelected) {
            onCheckedChange(orderItem.copy(isSelected = it))
        }

        Image(
            modifier = Modifier
                .size(90.dp)
                .clip(Shape4),
            painter = rememberAsyncImagePainter(product.imageUrl),
            contentDescription = product.name,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .heightIn(min = 90.dp)
                .weight(1f)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = product.name,
                    style = ProductTitleTextStyle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Icon(
                    modifier = Modifier.clickable {
                        onDeleteClick(orderItem)
                    }, imageVector = Icons.Rounded.Delete, contentDescription = null
                )
            }

            Text(
                text = product.description,
                style = ProductTitleTextStyle,
                maxLines = 2,
                fontSize = 10.sp,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalAlignment = Alignment.Bottom, // Align content to the bottom
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.price, product.price),
                    style = ProductPriceTextStyle,
                    fontSize = 18.sp
                )
                product.oldPrice?.let {
                    Text(
                        text = stringResource(R.string.old_price, it),
                        style = ProductOldPriceTextStyle,
                        fontSize = 14.sp
                    )
                }
                product.discount?.let {
                    Text(
                        modifier = Modifier
                            .border(
                                width = 0.3.dp, color = RoseRed, shape = Shape4
                            )
                            .padding(
                                horizontal = 4.dp, vertical = 2.dp
                            ),
                        text = "-$it %",
                        style = ProductPriceTextStyle,
                        fontSize = 12.sp,
                        color = RoseRed,
                        textAlign = TextAlign.Center
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                thickness = 1.dp,
                color = CoolGray
            )
        }
    }
}


@Preview
@Composable
private fun OrderItemPrev() {
}
