package am.stylish.app.common_presentation.components.text

import am.stylish.app.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppSubTitle(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 20,
    color: Color = Color.Black,
    icon: @Composable (() -> Unit)? = null
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        icon?.invoke()

        Text(
            text = text,
            style = TextStyle(
                fontSize = fontSize.sp,
                lineHeight = 22.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                fontWeight = FontWeight.W200,
                color = color,
            )
        )
    }
}