package am.stylish.app.main.cart.presentation

import am.stylish.app.R
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_presentation.components.action_bar.AppActionBar
import am.stylish.app.common_presentation.components.address.AddressSection
import am.stylish.app.common_presentation.components.card.CheckoutSummaryCard
import am.stylish.app.common_presentation.components.loading.AppLoadingAnimation
import am.stylish.app.common_presentation.components.product_list.CartProductList
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import am.stylish.app.common_presentation.components.text.AppSubTitle
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import am.stylish.app.common_presentation.view_model.CartViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel


@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    viewModel: CartScreenViewModel = koinViewModel(),
    cartViewModel: CartViewModel = koinViewModel(),
    onProductClick: (Product) -> Unit = {},
    onBackClick: () -> Unit = {},
    onSnackbarShown: (SnackbarState) -> Unit = {},
    navigateToOrderDetails: (List<String>) -> Unit = {}
) {
    val screenState by viewModel.screenState.collectAsState(CartScreenState.Loading)
    LaunchedEffect(Unit) {
        viewModel.fetchCartItems()
    }

    when (val state = screenState) {
        is CartScreenState.Error -> {
            LaunchedEffect(screenState) {
                onSnackbarShown(
                    SnackbarState.Error(
                        _message = R.string.something_went_wrong,
                        _icon = R.drawable.ic_error,
                    )
                )
            }
        }

        CartScreenState.Loading -> {
            AppLoadingAnimation(
                modifier = Modifier.fillMaxSize()
            )
        }

        is CartScreenState.Success -> {
            CartScreenContent(
                modifier = modifier,
                products = state.cartItems.toMutableStateList(),
                onProductClick = onProductClick,
                onBackClick = onBackClick,
                onDeleteClick = {
                    cartViewModel.deleteCartItem(it) {
                        onSnackbarShown(it)
                    }
                },
                navigateToOrderDetails = navigateToOrderDetails
            )
        }
    }
}

@Composable
private fun CartScreenContent(
    modifier: Modifier = Modifier,
    products: SnapshotStateList<Product>,
    onProductClick: (Product) -> Unit = {},
    onDeleteClick: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
    navigateToOrderDetails: (List<String>) -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(SoftWhite)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AppActionBar(
                modifier = Modifier
                    .fillMaxWidth(),
                showStartContent = true,
                showCenterContent = true,
                startContent = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            modifier = Modifier
                                .width(12.dp)
                                .height(20.dp),
                            painter = painterResource(R.drawable.ic_back),
                            contentDescription = null
                        )
                    }
                },
                centerContent = {
                    Text(
                        text = stringResource(R.string.add_to_cart),
                        style = AuthTitleTextStyle,
                        fontSize = 18.sp,
                        color = Color.Black,
                    )
                }
            )
            HorizontalDivider(Modifier.fillMaxWidth(), thickness = 0.5.dp, color = CoolGray)


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AppSubTitle(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                    text = stringResource(R.string.delivery_address),
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_location),
                            contentDescription = null,
                            tint = Color.Unspecified,
                        )
                    })

                AddressSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

                if (products.isNotEmpty()) {
                    AppSubTitle(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                top = 14.dp,
                                end = 16.dp,
                            ),
                        text = stringResource(R.string.shopping_list),
                    )

                    CartProductList(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 124.dp),
                        products = products,
                        onDeleteClick = onDeleteClick,
                        onProductClick = onProductClick,
                    )

                } else {
                    Text(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        text = stringResource(R.string.there_are_no_items_in_the_cart),
                        style = AuthTitleTextStyle,
                        fontSize = 18.sp,
                        color = RoseRed,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        CheckoutSummaryCard(
            isExpanded = products.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            price = products.sumOf { it.price }
        ) {
            navigateToOrderDetails(products.map { it.id })
        }
    }
}