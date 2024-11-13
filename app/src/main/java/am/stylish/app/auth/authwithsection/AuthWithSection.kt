package am.stylish.app.auth.authwithsection

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.LightGrayText
import am.stylish.app.common_presentation.ui.theme.RoseRed
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthWithSection(modifier: Modifier = Modifier, bottomSectionText: @Composable () -> Unit) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.or_continue_with),
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                fontWeight = FontWeight.W500,
                color = LightGrayText,
                textAlign = TextAlign.Center,
            ),
        )

        Row(
            modifier = Modifier.padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                alignment = Alignment.CenterHorizontally,
                space = 12.dp,
            )
        ) {
            AuthWithItem(icon = R.drawable.ic_google)
            AuthWithItem(icon = R.drawable.ic_apple)
            AuthWithItem(icon = R.drawable.ic_facebook)
        }

        Spacer(modifier = Modifier.height(26.dp))

        bottomSectionText()
    }
}


@Composable
private fun AuthWithItem(modifier: Modifier = Modifier, icon: Int) {
    Surface(
        shape = CircleShape,
        border = BorderStroke(1.dp, RoseRed),
        color = Color(0xFFFCF3F6),
    ) {
        Box(
            modifier = Modifier.padding(15.dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = modifier.size(24.dp),
                painter = painterResource(id = icon),
                contentDescription = null
            )
        }
    }
}