package am.stylish.app.common_presentation.components.card

import am.stylish.app.R
import am.stylish.app.common_presentation.components.button.SolidButton
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import am.stylish.app.common_presentation.ui.theme.CoolGray
import am.stylish.app.common_presentation.ui.theme.SoftGray
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckoutSummaryCard(
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    price: Int = 0,
    navigateToOrderDetails: () -> Unit = {}
) {
    AnimatedVisibility(modifier = modifier, visible = isExpanded) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .border(
                    border = BorderStroke(0.3.dp, CoolGray),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                ),
            colors = CardDefaults.cardColors(SoftGray),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 12.dp, vertical = 16.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(R.string.price, price),
                    style = AuthTitleTextStyle,
                    fontSize = 18.sp,
                )

                SolidButton(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(R.string.proceed_to_payment),
                    fontSize = 17
                ) {
                    navigateToOrderDetails()
                }
            }
        }
    }
}