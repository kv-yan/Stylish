package am.stylish.app.common_domain.model.details

import am.stylish.app.common_domain.model.product.ProductColor

data class ProductDetails(
    val productId: String,
    val title: String,
    val shortDescription: String,
    val longDescription: String,
    val size: List<String>,
    val color: List<ProductColor>,
    val price: String,
    val oldPrice: String? = null,
    val imageUrl: List<String>,
    val rating: Float,
    val reviewsCount: Int,
    val discount: Int? = 50,
)