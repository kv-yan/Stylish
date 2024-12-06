package am.stylish.app.common_presentation.components.product_list

import am.stylish.app.R
import am.stylish.app.common_domain.model.product.PageProduct
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_domain.model.product.ProductListType
import am.stylish.app.common_domain.model.special_offer.SpecialOfferType
import am.stylish.app.common_presentation.components.cpecial_offers.deal_of_day.DealOfDayOffer
import am.stylish.app.common_presentation.components.cpecial_offers.image.ImageSpecialOffer
import am.stylish.app.common_presentation.components.cpecial_offers.image_with_text.OfferWithImageAndTitle
import am.stylish.app.common_presentation.components.cpecial_offers.pager.PagerSpecialOffer
import am.stylish.app.common_presentation.utils.test_mock_data.mockPageProductData
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette

@Composable
fun ProductListWithSpecialOffers(
    modifier: Modifier = Modifier,
    products: List<PageProduct>,
    onProductClick: (Product) -> Unit = {},
    onWishedClick: (String) -> Unit = {},
    onSpecialOfferClick: (PageProduct.PageSpecialOffer) -> Unit = {}
) {
    val context = LocalContext.current
    LazyColumn(modifier = modifier.heightIn(min = 0.dp, max = 1500.dp)) {
        items(products, key = { it.id }) { item ->
            when (item) {
                is PageProduct.ProductList -> {

                    when (item.productListType) {
                        ProductListType.GRID -> {
                            val rows = (item.products.size + 1) / 2
                            val gridHeight = (rows * 350).dp
                            ProductListGrid(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(
                                        min = 0.dp,
                                        max = gridHeight
                                    ),
                                products = item.products,
                                onProductClick = {
                                    onProductClick(it)
                                },
                                onWishlistClick = {
                                    onWishedClick(it)
                                }
                            )
                        }

                        ProductListType.LIST -> {
                            // TODO: not implemented yet
                        }

                        ProductListType.STAGGERED_GRID -> {
                            val rows = (item.products.size + 1) / 2
                            val gridHeight = (rows * 350).dp
                            ProductListStaggeredGrid(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(
                                        min = 0.dp,
                                        max = gridHeight
                                    ),
                                products = item.products
                            ) {
                                onProductClick(it)
                            }
                        }

                        ProductListType.PAGER -> {
                            ProductListPager(
                                modifier = Modifier.fillMaxWidth(),
                                products = item.products,
                                onProductClick = {
                                    onProductClick(it)
                                },
                                onWishedClick = {
                                    onWishedClick(it)
                                }
                            )
                        }
                    }
                }

                is PageProduct.PageSpecialOffer -> {

                    when (item.specialOffer.offerType) {
                        SpecialOfferType.PAGER -> {
                            PagerSpecialOffer(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                sourceList = listOf(
                                    R.drawable.pager_special_offer,
                                    R.drawable.pager_special_offer,
                                    R.drawable.pager_special_offer,
                                ),
                                imageLoader = { resId ->
                                    Image(
                                        modifier = Modifier.fillMaxSize(),
                                        painter = painterResource(resId),
                                        contentDescription = null,
                                        contentScale = ContentScale.FillWidth
                                    )
                                },
                                onClick = { onSpecialOfferClick(item) },
                                extractColor = { imageRes ->
                                    val bitmap =
                                        BitmapFactory.decodeResource(context.resources, imageRes)
                                    val palette = Palette.from(bitmap).generate()
                                    Color(palette.getDominantColor(Color.Gray.toArgb()))
                                }
                            )
                        }

                        SpecialOfferType.IMAGE -> {
                            ImageSpecialOffer(
                                modifier = Modifier,
                                sourceList = R.drawable.image_special_offer,
                                imageLoader = { resId ->
                                    Image(
                                        modifier = Modifier.fillMaxSize(),
                                        painter = painterResource(resId),
                                        contentDescription = null,
                                        contentScale = ContentScale.FillWidth
                                    )
                                },
                                onClick = {
                                    onSpecialOfferClick(item)
                                }
                            )
                        }

                        SpecialOfferType.BANNER -> {
                            // TODO: not implemented yet
                        }

                        SpecialOfferType.DEAL_OF_DAY -> {
                            DealOfDayOffer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                        top = 16.dp,
                                    ), offer = item.specialOffer
                            ) {
                                onSpecialOfferClick(item)
                            }
                        }

                        SpecialOfferType.SPECIAL_OFFER -> {
                            // TODO: not implemented yet
                        }

                        SpecialOfferType.IMAGE_WITH_TEXT -> {
                            OfferWithImageAndTitle(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                offer = item.specialOffer
                            ) {
                                onSpecialOfferClick(item)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun ProductListWithSpecialOffersPrev() {
    ProductListWithSpecialOffers(products = mockPageProductData)
}