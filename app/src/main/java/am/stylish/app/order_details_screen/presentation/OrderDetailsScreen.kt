package am.stylish.app.order_details_screen.presentation

import am.stylish.app.R
import am.stylish.app.common_presentation.components.action_bar.AppActionBar
import am.stylish.app.common_presentation.components.card.CheckoutSummaryCard
import am.stylish.app.common_presentation.components.items.OrderItem
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import am.stylish.app.common_presentation.components.text.AppSubTitle
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.ui.theme.ProductDiscountTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductPriceTextStyle
import am.stylish.app.common_presentation.ui.theme.ProductTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.common_presentation.utils.test_mock_data.mockProductsDataIds
import am.stylish.app.order_details_screen.domain.model.OrderItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun OrderDetailsScreen(
    modifier: Modifier = Modifier,
    products: List<String> = mockProductsDataIds,
    viewModel: OrderDetailsViewModel = getViewModel { parametersOf(products) },
    onBackClick: () -> Unit = {},
    onSnackbarShown: (SnackbarState) -> Unit = {},
) {
    val screenState by viewModel.screenState.collectAsState()
    val orderItemsList by viewModel.orderItemsList.collectAsState()
    val totalPrice by viewModel.totalPrice.collectAsState()

    LaunchedEffect(orderItemsList) {
        viewModel.calculateTotalPrice()
    }

    when (screenState) {
        is OrderDetailsScreenState.Error -> {
            LaunchedEffect(screenState) {
                onSnackbarShown(
                    SnackbarState.Error(
                        _message = R.string.something_went_wrong,
                        _icon = R.drawable.ic_error,
                    )
                )
            }
        }

        OrderDetailsScreenState.Loading -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = RoseRed, strokeWidth = 4.dp)
            }
        }

        is OrderDetailsScreenState.Success -> {

            OrderDetailsScreenContent(modifier = modifier
                .fillMaxSize()
                .systemBarsPadding(),
                orderItems = orderItemsList,
                totalPrice = totalPrice,
                onBackClick = onBackClick,
                onItemUpdate = { viewModel.updateOrderItem(it) },
                onRemoveItem = { viewModel.removeOrderItem(it) })
        }
    }
}

@Composable
fun OrderDetailsScreenContent(
    modifier: Modifier = Modifier,
    orderItems: List<OrderItem> = emptyList(),
    totalPrice: Int = 0,
    onBackClick: () -> Unit = {},
    onItemUpdate: (OrderItem) -> Unit = {},
    onRemoveItem: (OrderItem) -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier) {
            AppActionBar(modifier = Modifier.fillMaxWidth(),
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
                        text = stringResource(R.string.order_details),
                        style = AuthTitleTextStyle,
                        fontSize = 18.sp,
                        color = Color.Black,
                    )
                })

            if (orderItems.isEmpty()) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_cart),
                        contentDescription = null,
                        tint = RoseRed
                    )
                    Text(
                        text = stringResource(R.string.there_are_no_items_in_the_cart),
                        style = AuthTitleTextStyle,
                        fontSize = 18.sp,
                        color = Color.Black,
                    )
                }
            } else LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(orderItems) { item ->
                    Box(
                        modifier = Modifier
                            .animateItem(fadeInSpec = null, fadeOutSpec = null)
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        OrderItem(modifier = Modifier
                            .animateItem()
                            .fillMaxWidth(),
                            orderItem = item,
                            onCheckedChange = { onItemUpdate(it) },
                            onDeleteClick = { onRemoveItem(it) })
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(32.dp))

                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = CoolGray
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    AppSubTitle(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp),
                        text = stringResource(R.string.order_payment_details),
                        fontSize = 18
                    )


                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            modifier = Modifier.weight(1f),
                            text = stringResource(R.string.order_amounts),
                            style = ProductTitleTextStyle,
                            fontSize = 18.sp,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            color = Color.Black,
                        )
                        Text(
                            text = stringResource(R.string.price, totalPrice),
                            style = ProductPriceTextStyle,
                            fontSize = 18.sp,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                        )
                    }

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            modifier = Modifier.weight(1f),
                            text = stringResource(R.string.delivery_fee),
                            style = ProductTitleTextStyle,
                            fontSize = 17.sp,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            color = Color.Black,
                        )
                        Text(
                            text = stringResource(R.string.free),
                            style = ProductDiscountTextStyle,
                            fontSize = 17.sp,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = CoolGray
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    AppSubTitle(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp),
                        text = stringResource(R.string.address_details),
                        fontSize = 18
                    )


                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            modifier = Modifier.weight(1f),
                            text = stringResource(R.string.address),
                            style = ProductTitleTextStyle,
                            fontSize = 18.sp,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            color = Color.Black,
                        )
                        Text(
                            text = stringResource(R.string.test_address, totalPrice),
                            style = ProductPriceTextStyle,
                            fontSize = 14.sp,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(124.dp))
                }
            }
        }


        CheckoutSummaryCard(
            isExpanded = totalPrice > 10,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            price = totalPrice
        ) {
            // Proceed to payment logic
        }
    }
}

@Preview
@Composable
private fun OrderDetailsScreenPrev() {
    OrderDetailsScreen(modifier = Modifier.fillMaxSize())
}