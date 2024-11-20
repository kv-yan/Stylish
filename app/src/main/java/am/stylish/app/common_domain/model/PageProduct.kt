package am.stylish.app.common_domain.model

sealed class PageProduct {
    data class ProductList(
        val products: List<Product>,
        val productListType: ProductListType,
    ) : PageProduct()

    data class PageSpecialOffer(
        val specialOffer: SpecialOffer,
    ) : PageProduct()
}