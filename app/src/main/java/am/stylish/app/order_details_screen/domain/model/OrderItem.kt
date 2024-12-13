package am.stylish.app.order_details_screen.domain.model

import am.stylish.app.common_domain.model.product.Product
import java.util.UUID

data class OrderItem(
    val id: String = UUID.randomUUID().toString(),
    val isSelected: Boolean = false,
    val product: Product,
    val quantity: Int,
    val color: String,
    val size: String
)