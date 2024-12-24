package am.stylish.app.common_presentation.components.items

import am.stylish.app.R
import am.stylish.app.add_payment_method.domain.model.PaymentMethod
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.common_presentation.ui.theme.Shape8
import am.stylish.app.common_presentation.ui.theme.WildSand
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PaymentMethodItem(
    modifier: Modifier = Modifier,
    paymentMethod: PaymentMethod,
    isSelect: Boolean = false,
    onItemClick: () -> Unit = {}
) {

    Row(modifier = modifier
        .clip(Shape8)
        .clickable { onItemClick() }
        .then(if (isSelect) Modifier.border(1.dp, RoseRed, Shape8) else Modifier)
        .background(WildSand)
        .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        Image(
            modifier = Modifier
                .height(20.dp)
                .widthIn(max = 48.dp),
            painter = paymentMethod.type.image.let { painterResource(id = it) },
            contentDescription = null
        )

        Text(
            text = paymentMethod.value, style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 29.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF6E7179),
            )
        )

    }

}