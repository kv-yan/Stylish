package am.stylish.app.checkout.presentation

import am.stylish.app.R
import am.stylish.app.add_payment_method.presentation.PaymentViewModel
import am.stylish.app.common_presentation.components.action_bar.AppActionBar
import am.stylish.app.common_presentation.components.button.SolidButton
import am.stylish.app.common_presentation.components.dialog.PaymentDialog
import am.stylish.app.common_presentation.components.items.PaymentMethodItem
import am.stylish.app.common_presentation.components.text.AppSubTitle
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.ui.theme.CoralRed
import am.stylish.app.common_presentation.ui.theme.DescriptionColor
import am.stylish.app.common_presentation.ui.theme.MineShaft
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.common_presentation.ui.theme.SoftWhite
import am.stylish.app.common_presentation.ui.theme.SpecialOfferDescriptionTextStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CheckoutScreen(
    orderPrice: Int = 0,
    modifier: Modifier = Modifier,
    viewModel: CheckoutViewModel = getViewModel { parametersOf(orderPrice) },
    paymentViewModel: PaymentViewModel = koinViewModel(),
    onBackClick: () -> Unit = {},
    onAddPaymentMethodClick: () -> Unit = {}
) {

    val paymentMethods by paymentViewModel.paymentMethods.collectAsState()
    val selectedPaymentMethod by paymentViewModel.selectedPaymentMethod.collectAsState()
    val totalPrice by viewModel.totalPrice.collectAsState()
    val shippingPrice by viewModel.shippingPrice.collectAsState()
    val showingPaymentResultDialog by viewModel.showingPaymentResultDialog.collectAsState()
    val paymentDialogState by viewModel.paymentDialogState.collectAsState()

    PaymentDialog(isExpanded = showingPaymentResultDialog, dialogState = paymentDialogState) {
        viewModel.hidePaymentResultDialog()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppActionBar(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
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
                    text = stringResource(R.string.checkout),
                    style = AuthTitleTextStyle,
                    fontSize = 18.sp,
                    color = Color.Black,
                )
            })

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 0.5.dp,
            color = CoolGray,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            CheckoutDetailsText(
                modifier = Modifier.fillMaxWidth(),
                titleText = stringResource(R.string.order_amounts),
                valueText = totalPrice?.let { stringResource(R.string.price, it) }
                    ?: stringResource(R.string.counting),
                fontSize = 16,
                tint = DescriptionColor,
            )

            CheckoutDetailsText(
                modifier = Modifier.fillMaxWidth(),
                titleText = stringResource(R.string.shipping),
                valueText = shippingPrice?.let { stringResource(R.string.price, it) }
                    ?: stringResource(R.string.counting),
                fontSize = 15,
                tint = DescriptionColor,
            )

            CheckoutDetailsText(
                modifier = Modifier.fillMaxWidth(),
                titleText = stringResource(R.string.total),
                valueText = stringResource(R.string.price,
                    shippingPrice?.let { totalPrice?.plus(it) }
                        ?: stringResource(R.string.counting)),
                fontSize = 16,
                tint = MineShaft,
            )

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.5.dp,
                color = CoolGray,
            )
        }


        if (paymentMethods.isEmpty()) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.no_payment_methods),
                style = SpecialOfferDescriptionTextStyle,
                fontSize = 18.sp,
                lineHeight = TextUnit.Unspecified,
                color = CoralRed,
                textAlign = TextAlign.Center,
            )

            SolidButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 22.dp,
                        vertical = 36.dp
                    ),
                text = stringResource(R.string.add_payment_method)
            ) {
                onAddPaymentMethodClick()
            }

        } else {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        start = 22.dp,
                        end = 22.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppSubTitle(
                    modifier = Modifier.weight(1f),
                    text = stringResource(R.string.payment),
                    fontSize = 18,
                )

                IconButton(
                    onClick = { onAddPaymentMethodClick() },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = RoseRed, contentColor = SoftWhite
                    )
                ) {
                    Icon(
                        modifier = Modifier
                            .width(12.dp)
                            .height(20.dp),
                        imageVector = Icons.Rounded.Add,
                        contentDescription = stringResource(R.string.add_payment_method),
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(
                    )
            ) {
                items(paymentMethods, key = { it.value }) {
                    PaymentMethodItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 22.dp,
                                end = 22.dp,
                                bottom = 24.dp,
                            ),
                        paymentMethod = it,
                        isSelect = it == selectedPaymentMethod,
                    ) {
                        paymentViewModel.setPaymentMethod(it)
                    }
                }
            }

            SolidButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp),
                text = stringResource(R.string.continue_to_checkout),
                isEnabled = selectedPaymentMethod != null,
            ) {
                viewModel.showPaymentResultDialog()
            }
        }
    }
}

@Composable
private fun CheckoutDetailsText(
    modifier: Modifier = Modifier,
    titleText: String,
    valueText: String,
    tint: Color = Color.Black,
    fontSize: Int = 16,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            modifier = Modifier,
            text = titleText,
            style = SpecialOfferDescriptionTextStyle,
            fontSize = fontSize.sp,
            color = tint
        )

        Text(
            modifier = Modifier,
            text = valueText,
            style = SpecialOfferDescriptionTextStyle,
            fontSize = fontSize.sp,
            color = tint
        )
    }
}

@Preview
@Composable
private fun CheckoutScreenPrev() {
    CheckoutScreen()
}