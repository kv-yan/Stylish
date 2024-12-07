package am.stylish.app.main.cart.presentation

import am.stylish.app.R
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.components.action_bar.MainMenuActionBarContent
import am.stylish.app.common_presentation.components.product_list.ProductListStaggeredGrid
import am.stylish.app.common_presentation.components.search.SearchBar
import am.stylish.app.common_presentation.components.snackbar.SnackbarState
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.CoralRed
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.common_presentation.ui.theme.SoftWhite
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
import org.koin.androidx.compose.koinViewModel


@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    viewModel: CartScreenViewModel = koinViewModel(),
    onProductClick: (Product) -> Unit = {},
    onBackClick: () -> Unit = {},
    onSnackbarShown: (SnackbarState) -> Unit = {}
) {
    val cartScreenState by viewModel.screenState.collectAsState(CartScreenState.Loading)
    LaunchedEffect(Unit) {
        viewModel.fetchCartItems()
    }

    when (val state = cartScreenState) {
        is CartScreenState.Error -> {
            onSnackbarShown(
                SnackbarState.Error(
                    _message = R.string.something_went_wrong,
                    _icon = R.drawable.ic_error
                )
            )
        }

        CartScreenState.Loading -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = RoseRed, strokeWidth = 4.dp)
            }
        }

        is CartScreenState.Success -> {
            CartScreenContent(
                modifier = modifier,
                products = state.cartItems,
                onProductClick = onProductClick
            )
        }
    }
}

@Composable
private fun CartScreenContent(
    modifier: Modifier = Modifier,
    products: List<Product>,
    onProductClick: (Product) -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SoftWhite)
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
        if (products.isNotEmpty()) {

            ProductListStaggeredGrid(
                modifier = Modifier.fillMaxSize(), products = products,
                onProductClick = onProductClick,
                onAddToCart = { _, _ -> },
                onRemoveFromCart = { _, _ -> },
                onCartClick = {},
                onWishlistClick = {}
            )

        } else {
            Text(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                text = stringResource(R.string.there_are_no_items_in_the_cart),
                style = AuthTitleTextStyle,
                fontSize = 18.sp,
                color = CoralRed,
                textAlign = TextAlign.Center
            )
        }
    }
}