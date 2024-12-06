package am.stylish.app.common_domain.model.product

import am.stylish.app.common_domain.model.special_offer.SpecialOffer
import java.util.UUID

sealed class PageProduct(val id: String) {
    data class ProductList(
        private val _id: String = UUID.randomUUID().toString(),
        val products: List<Product>,
        val productListType: ProductListType,
    ) : PageProduct(_id)

    data class PageSpecialOffer(
        private val _id: String = UUID.randomUUID().toString(),
        val specialOffer: SpecialOffer,
    ) : PageProduct(_id)
}