package am.stylish.app.common_presentation.components.button

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.Shape4
import am.stylish.app.common_presentation.ui.theme.SpecialOfferTitleTextStyle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun ButtonViewAll(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    contentColor: Color = Color.White,
    onClick: () -> Unit = {}
) {
    OutlinedButton(modifier = modifier,
        shape = Shape4,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = backgroundColor,
            contentColor = Color.White,
        ),
        border = BorderStroke(width = 1.dp, color = Color.White),
        onClick = { onClick() }) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                text = stringResource(id = R.string.view_all),
                color = contentColor,
                style = SpecialOfferTitleTextStyle
            )
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                contentDescription = null,
                tint = contentColor
            )
        }
    }

}