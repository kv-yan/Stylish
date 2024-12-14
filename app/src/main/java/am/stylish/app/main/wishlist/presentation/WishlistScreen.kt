package am.stylish.app.main.wishlist.presentation

import am.stylish.app.R
import am.stylish.app.common_domain.entity.CartItem
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.components.action_bar.ItemsSummaryHeaderWithActions
import am.stylish.app.common_presentation.components.action_bar.MainMenuActionBarContent
import am.stylish.app.common_presentation.components.product_list.ProductListStaggeredGrid
import am.stylish.app.common_presentation.components.search.SearchBar
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.CoralRed
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import am.stylish.app.common_presentation.view_model.CartViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel


@Composable
fun WishlistScreen(
    modifier: Modifier = Modifier,
    viewModel: WishlistViewModel = koinViewModel(),
    onProductClick: (Product) -> Unit = {},
    onSnackbarShown: (SnackbarState) -> Unit = {}
) {
    val screenState by viewModel.wishlistScreenState.collectAsState()
    val cartViewModel = koinViewModel<CartViewModel>()
    val cartList by cartViewModel.cartList.collectAsStateWithLifecycle()


    when (val state = screenState) {
        is WishlistScreenState.Error -> {
            LaunchedEffect(screenState) {
                onSnackbarShown(
                    SnackbarState.Error(
                        _message = R.string.something_went_wrong,
                        _icon = R.drawable.ic_error,
                    )
                )
            }

        }

        WishlistScreenState.Loading -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = CoralRed, strokeWidth = 4.dp)
            }
        }

        is WishlistScreenState.Success -> {
            LaunchedEffect(true) {
                viewModel.fetchWishlistItems()
            }
            WishlistScreenContent(
                modifier = modifier.fillMaxSize(),
                wishlistState = state.wishlistItems,
                onProductClick = onProductClick,
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
private fun WishlistScreenContent(
    modifier: Modifier = Modifier,
    wishlistState: List<Product>,
    onProductClick: (Product) -> Unit = {},
    onAddToCart: (String, Int) -> Unit = { _, _ -> },
    isItemInCart: (String) -> CartItem? = { null }
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .background(SoftWhite)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        MainMenuActionBarContent()

        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                ),
            text = stringResource(R.string.search_any_product),
        )
        if (wishlistState.isNotEmpty()) {
            ItemsSummaryHeaderWithActions(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                    ),
                title = stringResource(R.string.items, wishlistState.size),
            )

            ProductListStaggeredGrid(
                modifier = Modifier.fillMaxSize(),
                products = wishlistState,
                onProductClick = onProductClick,
                onAddToCart = { id, quantity -> onAddToCart(id, quantity) },
                onRemoveFromCart = { _, _ -> },
                onWishlistClick = {},
                isItemInCart = { isItemInCart(it) }
            )

        } else {
            Text(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                text = stringResource(R.string.there_are_no_items_in_the_wishlist),
                style = AuthTitleTextStyle,
                fontSize = 18.sp,
                color = RoseRed,
                textAlign = TextAlign.Center
            )
        }
    }
}