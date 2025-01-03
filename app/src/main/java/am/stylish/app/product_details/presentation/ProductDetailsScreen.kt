package am.stylish.app.product_details.presentation

import am.stylish.app.R
import am.stylish.app.common_domain.entity.CartItem
import am.stylish.app.common_domain.model.details.ProductDetails
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.components.action_bar.AppActionBar
import am.stylish.app.common_presentation.components.button.IconTextButton
import am.stylish.app.common_presentation.components.button.PurchaseButton
import am.stylish.app.common_presentation.components.items.RatingBar
import am.stylish.app.common_presentation.components.loading.AppLoadingAnimation
import am.stylish.app.common_presentation.components.pager.ProductImagePager
import am.stylish.app.common_presentation.components.product_components.ProductSizeSection
import am.stylish.app.common_presentation.components.product_list.ProductListGrid
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import am.stylish.app.common_presentation.components.text.ExpandableAnnotatedText
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.CloudGray
import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.ui.theme.DeepOceanBlue
import am.stylish.app.common_presentation.ui.theme.ForestGreen
import am.stylish.app.common_presentation.ui.theme.MintGreen
import am.stylish.app.common_presentation.ui.theme.PastelPink
import am.stylish.app.common_presentation.ui.theme.ProductDiscountTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductOldPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductReviewQuantityTextStyle
import am.stylish.app.common_presentation.ui.theme.RegularDescriptionTextStyle
import am.stylish.app.common_presentation.ui.theme.Shape4
import am.stylish.app.common_presentation.ui.theme.Shape8
import am.stylish.app.common_presentation.ui.theme.SkyBlue
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import am.stylish.app.common_presentation.utils.test_mock_data.mockProductsData
import am.stylish.app.common_presentation.view_model.CartViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    productId: String = stringResource(R.string.empty_string),
    productDetailsViewModel: ProductDetailsViewModel = getViewModel { parametersOf(productId) },
    onBackClick: () -> Unit = {},
    onProductClick: (Product) -> Unit = {},
    onSnackBarShown: (SnackbarState) -> Unit = {},
    onImageClick: (List<String>, Int) -> Unit
) {
    val screenState by productDetailsViewModel.screenState.collectAsState()
    val isWishlistAdded by productDetailsViewModel.isWishlistAdded.collectAsState()
    val cartViewModel = koinViewModel<CartViewModel>()
    val cartList by cartViewModel.cartList.collectAsStateWithLifecycle()

    when (val state = screenState) {
        is DetailsScreenState.Error -> {
            LaunchedEffect(screenState) {
                onSnackBarShown(
                    SnackbarState.Error(
                        _message = R.string.something_went_wrong,
                        _icon = R.drawable.ic_error,
                    )
                )
            }
        }

        DetailsScreenState.Loading -> {
            AppLoadingAnimation(
                modifier = Modifier.fillMaxSize()
            )

        }

        is DetailsScreenState.Success -> {
            val details = state.productDetails
            ProductDetailsScreenContent(
                modifier = modifier
                    .fillMaxSize()
                    .background(SoftWhite),
                productDetails = details,
                isWishlistAdded = isWishlistAdded,
                onBackClick = onBackClick,
                onProductClick = onProductClick,
                onWishedClick = { itemId ->
                    productDetailsViewModel.toggleWishlist(id = itemId) {
                        onSnackBarShown(it)
                    }
                },
                onImageClick = { pagerPosition ->
                    onImageClick(
                        details.imageUrl,
                        pagerPosition
                    )
                },
                onCartClick = { id, quantity ->
                    cartViewModel.addCartItem(id) {
                        onSnackBarShown(it)
                    }
                },
                isItemInCart = { cartList.find { cartItem -> cartItem.id == it } }
            )
        }
    }
}


@Composable
fun ProductDetailsScreenContent(
    modifier: Modifier = Modifier,
    productDetails: ProductDetails,
    isWishlistAdded: Boolean,
    onBackClick: () -> Unit = {},
    onProductClick: (Product) -> Unit = {},
    onWishedClick: (String) -> Unit = {},
    onImageClick: (Int) -> Unit = {},
    onCartClick: (String, Int) -> Unit = { _, _ -> },
    isItemInCart: (String) -> CartItem? = { null }
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .systemBarsPadding()
            .verticalScroll(scrollState), verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AppActionBar(modifier = Modifier.fillMaxWidth(),
            showCenterContent = false,
            showStartContent = true,
            showEndContent = true,
            startContent = {
                IconButton(onClick = { onBackClick() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            },
            endContent = {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    IconButton(onClick = { onWishedClick(productDetails.productId) }) {
                        Icon(
                            painter = painterResource(
                                if (isWishlistAdded) R.drawable.ic_favorite_filled
                                else R.drawable.ic_favorite_outline
                            ), contentDescription = null, tint = Color.Black
                        )
                    }

                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.ShoppingCart,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            })

        ProductImagePager(
            modifier = Modifier.fillMaxWidth(),
            showingController = true,
            sourceList = productDetails.imageUrl,
        ) { pagerPosition ->
            onImageClick(pagerPosition)
        }

        ProductSizeSection(
            modifier = Modifier.fillMaxWidth(),
            sizeList = productDetails.size,
            selectedSize = productDetails.size.first()
        )

        Text(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            text = productDetails.title,
            style = AuthTitleTextStyle,
            fontSize = 20.sp
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = productDetails.shortDescription,
            style = RegularDescriptionTextStyle,
            textAlign = TextAlign.Start,
            color = Color.Black
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RatingBar(productDetails.rating, iconSize = 18)

            Text(
                text = productDetails.reviewsCount.toString(),
                style = ProductReviewQuantityTextStyle,
                color = CoolGray,
                fontSize = 14.sp
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            productDetails.oldPrice?.let {
                Text(
                    text = stringResource(R.string.old_price, it),
                    style = ProductOldPriceTextStyle,
                    fontSize = 14.sp
                )
            }

            Text(
                text = stringResource(R.string.price, productDetails.price),
                style = ProductPriceTextStyle,
                fontSize = 14.sp
            )

            productDetails.discount?.let {
                Text(
                    text = stringResource(R.string.off, it),
                    style = ProductDiscountTextStyle,
                    fontSize = 14.sp
                )
            }
        }

        Text(
            text = stringResource(R.string.product_details),
            style = ProductPriceTextStyle,
            fontSize = 14.sp,
        )

        ExpandableAnnotatedText(text = productDetails.longDescription)

        Row(
            modifier = Modifier.padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            PurchaseButton(
                text = stringResource(R.string.add_to_cart),
                icon = R.drawable.ic_cart,
                brush = Brush.verticalGradient(listOf(SkyBlue, DeepOceanBlue))
            ) // TODO: impl click action

            PurchaseButton(
                text = stringResource(R.string.buy_now),
                icon = R.drawable.ic_by_now,
                brush = Brush.verticalGradient(listOf(MintGreen, ForestGreen))
            ) // TODO: impl click action
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .clip(Shape4)
                .background(PastelPink)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 12.dp,
                    )
            ) {
                Text(
                    stringResource(R.string.delivery_in),
                    style = AuthTitleTextStyle,
                    fontSize = 16.sp
                )
                Text(
                    stringResource(R.string._1_within_hour),
                    style = AuthTitleTextStyle,
                    fontSize = 21.sp
                )
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            IconTextButton(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_visibility,
                contentTint = Color.Black,
                text = stringResource(R.string.view_similar),
                borderColor = CloudGray,
                backgroundColor = Color.White,
                shape = Shape8,
            ) { }
            IconTextButton(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_compere_product,
                contentTint = Color.Black,
                text = stringResource(R.string.add_to_compare),
                borderColor = CloudGray,
                backgroundColor = Color.White,
                shape = Shape8,
            ) { }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {

            Text(
                text = stringResource(R.string.similar_to),
                style = AuthTitleTextStyle,
                fontSize = 20.sp
            )
            Text(
                text = "282+ Items", style = AuthTitleTextStyle, fontSize = 18.sp
            )

        }

        val rows = mockProductsData.size + 1
        val gridHeight = (rows * 352).dp
        ProductListGrid(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 0.dp, max = gridHeight),
            products = mockProductsData,
            isItemInCart = isItemInCart,
            onProductClick = { onProductClick(it) },
            onWishlistClick = {
                onWishedClick(it)
            },
            onCartClick = {
                onCartClick(it, 1)
            }
        )
    }
}