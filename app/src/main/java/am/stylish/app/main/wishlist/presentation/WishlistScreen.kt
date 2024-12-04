package am.stylish.app.main.wishlist.presentation

import am.stylish.app.R
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.components.action_bar.ItemsSummaryHeaderWithActions
import am.stylish.app.common_presentation.components.action_bar.MainMenuActionBarContent
import am.stylish.app.common_presentation.components.product_list.ProductListStaggeredGrid
import am.stylish.app.common_presentation.components.search.SearchBar
import am.stylish.app.common_presentation.ui.theme.CoralRed
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel


@Composable
fun WishlistScreen(
    modifier: Modifier = Modifier,
    viewModel: WishlistViewModel = koinViewModel(),
    onProductClick: (Product) -> Unit = {}
) {
    val context = LocalContext.current
    val wishlistScreenState by viewModel.wishlistScreenState.collectAsState()

    when (val state = wishlistScreenState) {
        is WishlistScreenState.Error -> {
            val message = state.message
            // TODO:  ErrorScreen(message = message)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
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
                modifier = modifier,
                wishlistState = state.wishlistItems,
                onProductClick = onProductClick
            )
        }
    }
}

@Composable
private fun WishlistScreenContent(
    modifier: Modifier = Modifier,
    wishlistState: List<Product>,
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
                products = wishlistState
            ) {
                onProductClick(it)
            }
        }
    }
}