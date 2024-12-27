package am.stylish.app.main.search.domain.model

import am.stylish.app.common_domain.model.product.Product
import java.util.UUID

data class ProductCategory(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val image: Int,
    val products: List<Product> = emptyList()
)
