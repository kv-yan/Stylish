package am.stylish.app.common_presentation.components.cpecial_offers.image_with_text

import am.stylish.app.common_domain.model.SpecialOffer
import am.stylish.app.common_domain.model.SpecialOfferType
import am.stylish.app.common_presentation.components.button.ButtonViewAll
import am.stylish.app.common_presentation.ui.theme.RoseRed
import am.stylish.app.common_presentation.ui.theme.Shape12
import am.stylish.app.common_presentation.ui.theme.SpecialOfferTitleTextStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun OfferWithImageAndTitle(
    modifier: Modifier = Modifier,
    offer: SpecialOffer,
    onOfferClick: (SpecialOffer) -> Unit = {},
) {
    val imageUrl = offer.imageUrl.firstOrNull()
    Surface(modifier = modifier, shape = Shape12) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 200.dp, max = 250.dp),
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = offer.contentTitle,
                        style = SpecialOfferTitleTextStyle,
                        fontSize = 20.sp,
                    )

                    Text(
                        text = offer.contentDescription,
                        style = SpecialOfferTitleTextStyle,
                    )
                }
                ButtonViewAll(backgroundColor = RoseRed) {
                    onOfferClick(offer)
                }
            }
        }
    }
}

@Preview
@Composable
private fun OfferWithImageAndTitlePrev() {
    OfferWithImageAndTitle(
        modifier = Modifier,
        offer = SpecialOffer(
            offerType = SpecialOfferType.IMAGE_WITH_TEXT,
            contentTitle = "New Arrivals",
            contentDescription = "Summer’ 25 Collections",
            imageUrl = listOf("https://s3-alpha-sig.figma.com/img/f3ea/6b0e/b8c7849710cbe962e5c0069216c1d0ac?Expires=1733097600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=DP6SJIGyUQaIUGHo43fG2u4lj9URPDO49oWGSg1aKUvIk0JrmEi-OGyiCRiLphIwkW5YKhzzXo0db2NlMCrxwZwGlEKzT0Wg52OsGXlx3W7Z2-ScP56V8VQqoBxf1ydduJsIe3z~vhuJchjZX0n2DAfxeIP1iHob2t-~iozFxkGhxF09xMGvcUKPdFtuE5PW0RsmSjs4lmfEJzhDDWc61uB~GvVO6xtFPDHeDvYQrGQCpZGBAHmSE-aLUqbTcmcdwUYddyytApmJzKfX2aEBbznEEZBNAN-8KImo9Kq0W8Zp9DgOV5LsjGF4oMiv3lPspaO6t72xJuzHbUDjbxi1rg__")
        ),
    )
}