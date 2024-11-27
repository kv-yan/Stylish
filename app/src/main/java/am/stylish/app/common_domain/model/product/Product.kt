package am.stylish.app.common_domain.model.product

data class Product(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val price: Int = 0,
    val oldPrice: Int? = null,
    val discount: Int? = null,
    val rating: Float = 0f,
    val reviewsCount: Int? = null,
    val imageUrl: String = ""
)