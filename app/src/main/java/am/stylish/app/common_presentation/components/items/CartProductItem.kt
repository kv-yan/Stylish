package am.stylish.app.common_presentation.components.items

import am.stylish.app.R
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.ui.theme.CoralRed
import am.stylish.app.common_presentation.ui.theme.ProductOldPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.Shape10
import am.stylish.app.common_presentation.ui.theme.Shape4
import am.stylish.app.common_presentation.ui.theme.SpecialOfferDescriptionTextStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CartProductItem(
    modifier: Modifier = Modifier,
    product: Product,
    onDetailsClick: (String) -> Unit = {},
    onProductClick: (Product) -> Unit = {}
) {
    val quantity = 1
    Card(
        modifier = modifier,
        shape = Shape10,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = { onProductClick(product) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .size(124.dp)
                        .clip(Shape10),
                    painter = rememberAsyncImagePainter(product.imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )

                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 8.dp)
                        .fillMaxWidth()
                        .heightIn(0.dp, 134.dp), verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(end = 24.dp),
                            text = product.name,
                            style = AuthTitleTextStyle,
                            maxLines = 1,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 18.sp,
                        )

                        Icon(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .clickable {
                                    onDetailsClick(product.id)
                                },
                            imageVector = Icons.Rounded.Delete,
                            contentDescription = null
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Variations:",
                            style = SpecialOfferDescriptionTextStyle,
                            maxLines = 1,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 14.sp,
                        )

                        Row(
                            Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                modifier = Modifier
                                    .border(
                                        width = 0.3.dp, color = Color(0xFF0E0808), shape = Shape4
                                    )
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                text = "8 UK",
                                color = Color(0xFF0E0808),
                                textAlign = TextAlign.Center
                            )

                            Text(
                                modifier = Modifier
                                    .border(
                                        width = 0.3.dp, color = Color(0xFF0E0808), shape = Shape4
                                    )
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                text = "Black",
                                color = Color(0xFF0E0808)

                            )

                        }

                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(end = 8.dp),
                            text = product.rating.toString(),
                            style = AuthTitleTextStyle,
                            maxLines = 1,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 14.sp,
                        )

                        RatingBar(product.rating, 14)
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            Modifier.border(
                                width = 0.3.dp, color = Color(0xFFCACACA), shape = Shape4
                            )
                        ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                                text = stringResource(R.string.price_dollar, product.price),
                                style = AuthTitleTextStyle,
                                maxLines = 1,
                                color = Color.Black,
                                overflow = TextOverflow.Ellipsis,
                                fontSize = 18.sp,
                            )
                        }

                        product.discount?.let {
                            Column(modifier = Modifier.padding(start = 10.dp)) {
                                Text(
                                    text = "Upton ${product.discount} % off", style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 22.sp,
                                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                                        fontWeight = FontWeight.W500,
                                        color = CoralRed,
                                    )
                                )

                                Text(
                                    text = stringResource(R.string.price_dollar, product.price),
                                    style = ProductOldPriceTextStyle,
                                    maxLines = 1,
                                    color = CoolGray,
                                    fontSize = 16.sp,
                                )
                            }
                        }

                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = CoolGray
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.total_price, quantity),
                    style = ProductPriceTextStyle,
                )

                Text(
                    text = stringResource(R.string.price_dollar, product.price),
                    style = ProductPriceTextStyle,
                )
            }
        }
    }
}