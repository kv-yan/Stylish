package am.stylish.app.landing.presentation.pager

import am.stylish.app.R
import am.stylish.app.common_presentation.ui.theme.RegularDescriptionTextStyle
import am.stylish.app.landing.domain.model.LandingUiItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LandingPagerItem(modifier: Modifier = Modifier, item: LandingUiItem) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier.size(300.dp, 300.dp),
            painter = painterResource(id = item.icon),
            contentDescription = null
        )

        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = item.title,
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                fontWeight = FontWeight.W800,
            )
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 17.dp,
                    end = 17.dp,
                    top = 10.dp,
                ), text = item.description, style = RegularDescriptionTextStyle
        )
    }
}