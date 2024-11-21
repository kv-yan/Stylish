package am.stylish.app.common_presentation.components.cpecial_offers.deal_of_day

import am.stylish.app.R
import am.stylish.app.common_domain.model.SpecialOffer
import am.stylish.app.common_presentation.components.button.ButtonViewAll
import am.stylish.app.common_presentation.ui.theme.Shape4
import am.stylish.app.common_presentation.ui.theme.SpecialOfferDescriptionTextStyle
import am.stylish.app.common_presentation.ui.theme.SpecialOfferTitleTextStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun DealOfDayOffer(
    modifier: Modifier = Modifier,
    offer: SpecialOffer,
    onClick: () -> Unit,
) {
    val backgroundColor: Color = offer.contentBackgroundColor ?: Color.Transparent
    Surface(
        modifier = modifier, color = backgroundColor,
        shape = Shape4
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = stringResource(R.string.deal_of_the_day),
                    style = SpecialOfferTitleTextStyle,
                    color = Color.White
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(R.drawable.ic_alarm),
                        contentDescription = null,
                        tint = Color.White
                    )

                    Text(
                        stringResource(R.string.ends_in),
                        color = Color.White,
                        style = SpecialOfferDescriptionTextStyle
                    )
                }
            }

            ButtonViewAll {
                onClick()
            }
        }
    }
}