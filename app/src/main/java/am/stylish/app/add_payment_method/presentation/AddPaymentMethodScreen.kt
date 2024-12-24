package am.stylish.app.add_payment_method.presentation

import am.stylish.app.R
import am.stylish.app.common_presentation.components.action_bar.AppActionBar
import am.stylish.app.common_presentation.components.button.SolidButton
import am.stylish.app.common_presentation.components.snackbars.SnackbarState
import am.stylish.app.common_presentation.components.text.LabeledInputText
import am.stylish.app.common_presentation.components.text.visual_transformation.CardNumberVisualTransformation
import am.stylish.app.common_presentation.components.text.visual_transformation.ExpiryDateVisualTransformation
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.CoolGray
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddPaymentMethodScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onSnackBarShow: (SnackbarState) -> Unit = {}
) {
    AddPaymentMethodContent(
        modifier = modifier.fillMaxSize(),
        onBackClick = onBackClick,
        onSnackBarShow = onSnackBarShow
    )
}


@Composable
private fun AddPaymentMethodContent(
    modifier: Modifier = Modifier,
    paymentViewModel: PaymentViewModel = koinViewModel(),
    onBackClick: () -> Unit = {},
    onSnackBarShow: (SnackbarState) -> Unit = {}
) {

    val cardNumberState by paymentViewModel.cardNumber.collectAsState()
    val cardHolderNameState by paymentViewModel.cardHolderName.collectAsState()
    val expiryDateState by paymentViewModel.expiryDate.collectAsState()
    val securityCodeState by paymentViewModel.securityCode.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
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
                    text = stringResource(R.string.add_payment_method),
                    style = AuthTitleTextStyle,
                    fontSize = 18.sp,
                    color = Color.Black,
                )
            })

        HorizontalDivider(Modifier.fillMaxWidth(), thickness = 0.5.dp, color = CoolGray)

        // Card Number Field
        LabeledInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 24.dp),
            label = stringResource(R.string.card_number),
            value = cardNumberState,
            keyboardType = KeyboardType.Number,
            visualTransformation = CardNumberVisualTransformation(),
        ) {
            paymentViewModel.setCardNumber(it)
        }

        LabeledInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = stringResource(R.string.card_holder_name),
            value = cardHolderNameState,
        ) {
            paymentViewModel.setCardHolderName(it)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            // Expiry Date Field
            LabeledInputText(
                modifier = Modifier.weight(1f),
                label = stringResource(R.string.expiry_date),
                value = expiryDateState,
                keyboardType = KeyboardType.Number,
                visualTransformation = ExpiryDateVisualTransformation()
            ) {
                paymentViewModel.setExpiryDate(it)
            }

            // Security Code Field
            LabeledInputText(
                modifier = Modifier.weight(1f),
                label = stringResource(R.string.security_code),
                value = securityCodeState,
                keyboardType = KeyboardType.Number,
                aimAction = ImeAction.Done,
                limit = 3,
            ) {
                paymentViewModel.setSecurityCode(it)
            }
        }

        SolidButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 24.dp,
                ),
            text = stringResource(R.string.add_payment_method)
        ) {
            paymentViewModel.addPaymentMethod(cardNumberState) {
                onSnackBarShow(it)
                if (it is SnackbarState.Success) onBackClick()
            }
        }
    }
}

@Preview
@Composable
private fun AddPaymentMethodPrev() {
    AddPaymentMethodScreen()
}