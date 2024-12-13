package am.stylish.app.common_presentation.components.cpecial_offers.items

import am.stylish.app.common_domain.model.special_offer.SpecialOffer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun SpecialOfferItem(offer: SpecialOffer) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(offer.contentBackgroundColor ?: Color.LightGray)
            .padding(16.dp)
    ) {
        Text(text = offer.contentTitle)
        Text(text = offer.contentDescription)
        offer.imageUrl?.let {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = rememberAsyncImagePainter(it),
                contentDescription = offer.contentTitle
            )
        }
    }
}
