package am.stylish.app.common_domain.model

import androidx.compose.ui.graphics.Color

class SpecialOffer(
    val offerType: SpecialOfferType,
    val contentTitle: String,
    val contentDescription: String,
    val imageUrl: List<String> = emptyList(),
    val contentBackgroundColor: Color? = null,
)
