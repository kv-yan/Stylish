package am.stylish.app.main.home.presentation

import am.stylish.app.R
import am.stylish.app.common_domain.model.product.PageProduct
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_domain.model.special_offer.SpecialOffer
import am.stylish.app.common_presentation.components.action_bar.ItemsSummaryHeaderWithActions
import am.stylish.app.common_presentation.components.action_bar.MainMenuActionBarContent
import am.stylish.app.common_presentation.components.product_list.ProductListWithSpecialOffers
import am.stylish.app.common_presentation.components.search.SearchBar
import am.stylish.app.common_presentation.components.snackbar.SnackbarState
import am.stylish.app.common_presentation.ui.theme.CoralRed
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit = {},
    onSpecialOfferClick: (SpecialOffer) -> Unit = {},
    onSnackbarShown: (SnackbarState) -> Unit = {},
    viewModel: HomeViewModel = koinViewModel()

) {
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    when (val state = screenState) {
        is HomeScreenState.Error -> {
            onSnackbarShown(SnackbarState.Error(state.message))
        }

        HomeScreenState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    color = CoralRed,
                    strokeWidth = 4.dp,
                )
            }
        }

        is HomeScreenState.Success -> {
            HomeScreenContent(modifier = modifier,
                products = state.pageProduct,
                onProductClick = onProductClick,
                onSpecialOfferClick = onSpecialOfferClick,
                onWishedClick = {
                    viewModel.addToWishlist(it) { snackbar ->
                        onSnackbarShown(snackbar)
                    }
                })
        }
    }
}


@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier,
    products: List<PageProduct> = emptyList(),
    onProductClick: (Product) -> Unit = {},
    onSpecialOfferClick: (SpecialOffer) -> Unit = {},
    onWishedClick: (String) -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SoftWhite)
            .verticalScroll(scrollState)
    ) {
        MainMenuActionBarContent(Modifier)
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

        ItemsSummaryHeaderWithActions(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                ),
            title = "All Featured",
        )


        ProductListWithSpecialOffers(modifier = modifier.fillMaxSize(),
            products = products,
            onProductClick = onProductClick,
            onWishedClick = onWishedClick,
            onSpecialOfferClick = {
                onSpecialOfferClick(it.specialOffer)
            })
    }
}