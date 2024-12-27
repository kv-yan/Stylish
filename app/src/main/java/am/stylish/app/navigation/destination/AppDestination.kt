package am.stylish.app.navigation.destination

import kotlinx.serialization.Serializable

sealed class AppDestination {
    @Serializable
    data object Landing : AppDestination()

    @Serializable
    data object Auth : AppDestination()

    @Serializable
    data object Main : AppDestination()

    @Serializable
    data object GetStarted : AppDestination()

    @Serializable
    data class SpecialOfferDetails(val specialOfferId: String) : AppDestination()

    @Serializable
    data class ProductDetails(val productId: String) : AppDestination()

    @Serializable
    data class ProductFullScreenImages(
        val images: List<String>,
        val position: Int = 0
    ) : AppDestination()

    @Serializable
    data class OrderDetails(
        val productIds: List<String>,
    ) : AppDestination()

    @Serializable
    data class CategoryDetails(
        val categoryId: String
    ) : AppDestination()

    @Serializable
    data class Checkout(val totalPrice: Int) : AppDestination()

    @Serializable
    data object AddPaymentMethod : AppDestination()


}