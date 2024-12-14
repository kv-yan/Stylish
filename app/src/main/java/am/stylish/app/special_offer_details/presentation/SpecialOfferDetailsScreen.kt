package am.stylish.app.special_offer_details.presentation

import am.stylish.app.R
import am.stylish.app.common_domain.entity.CartItem
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_domain.model.special_offer.SpecialOffer
import am.stylish.app.common_presentation.components.action_bar.AppActionBar
import am.stylish.app.common_presentation.components.product_list.ProductListStaggeredGrid
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.CoralRed
import am.stylish.app.common_presentation.view_model.CartViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun SpecialOfferDetailsScreen(
    modifier: Modifier = Modifier,
    specialOfferId: String,
    viewModel: SpecialOfferDetailsViewModel = getViewModel { parametersOf(specialOfferId) },
    onBackClick: () -> Unit = {},
    onProductClick: (Product) -> Unit = {},
    onSnackbarShown: (SnackbarState) -> Unit = {},

    ) {
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()
    val cartViewModel = koinViewModel<CartViewModel>()
    val cartList by cartViewModel.cartList.collectAsStateWithLifecycle()

    when (screenState) {
        is SpecialOfferDetailsScreenState.Error -> {
            LaunchedEffect(screenState) {
                onSnackbarShown(
                    SnackbarState.Error(
                        _message = R.string.something_went_wrong,
                        _icon = R.drawable.ic_error,
                    )
                )
            }
        }

        SpecialOfferDetailsScreenState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = CoralRed,
                    strokeWidth = 4.dp
                )
            }
        }

        is SpecialOfferDetailsScreenState.Success -> {
            SpecialOfferDetailsScreenContent(
                modifier = modifier,
                specialOffer = (screenState as SpecialOfferDetailsScreenState.Success).specialOffer,
                onBackClick = onBackClick,
                onProductClick = onProductClick,
                onWishlistClick = {},
                onAddToCart = { id, _ ->
                    cartViewModel.addCartItem(id) {
                        onSnackbarShown(it)
                    }
                },
                isItemInCart = {
                    cartList.find { cartItem -> cartItem.id == it }
                }
            )
        }
    }
}

@Composable
private fun SpecialOfferDetailsScreenContent(
    modifier: Modifier = Modifier,
    specialOffer: SpecialOffer,
    onBackClick: () -> Unit = {},
    onProductClick: (Product) -> Unit = {},
    onWishlistClick: (String) -> Unit = {},
    onAddToCart: (String, Int) -> Unit = { _, _ -> },
    isItemInCart: (String) -> CartItem? = { null }
) {
    Scaffold(Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            AppActionBar(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
                showCenterContent = false,
                showStartContent = true,
                showEndContent = false,
                startContent = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                        Text(
                            text = specialOffer.contentTitle,
                            style = AuthTitleTextStyle,
                            fontSize = 21.sp
                        )
                    }
                }
            )

            ProductListStaggeredGrid(
                modifier = Modifier.fillMaxSize(),
                products = specialOffer.products,
                onProductClick = onProductClick,
                onAddToCart = { id, quantity -> onAddToCart(id, quantity) },
                onRemoveFromCart = { _, _ -> },
                onWishlistClick = onWishlistClick,
                isItemInCart = isItemInCart
            )
        }
    }
}