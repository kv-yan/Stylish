package am.stylish.app.common_domain.model.special_offer

import am.stylish.app.common_domain.model.product.Product
import androidx.compose.ui.graphics.Color
import java.util.UUID


class SpecialOffer(
    val offerId: String = UUID.randomUUID().toString(),
    val offerType: SpecialOfferType = SpecialOfferType.PAGER,
    val contentTitle: String = "",
    val contentBackgroundColor: Color? = null,
    val contentDescription: String = "",
    val imageUrl: List<String> = emptyList(),
    val products: List<Product> = emptyList(),
)
