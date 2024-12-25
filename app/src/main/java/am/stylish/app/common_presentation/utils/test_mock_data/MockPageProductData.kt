package am.stylish.app.common_presentation.utils.test_mock_data

import am.stylish.app.common_domain.model.product.PageProduct
import am.stylish.app.common_domain.model.product.ProductListType
import am.stylish.app.common_domain.model.special_offer.SpecialOffer
import am.stylish.app.common_domain.model.special_offer.SpecialOfferType

import am.stylish.app.common_presentation.ui.theme.DodgerBlue

val mockPageProductData = listOf(
    PageProduct.PageSpecialOffer(
        specialOffer = SpecialOffer(
            offerType = SpecialOfferType.PAGER,
            contentTitle = "50-40$ OFF",
            contentDescription = "New Arrivals in Stylish",
            imageUrl = listOf(
                "https://thumbs.dreamstime.com/b/red-banner-special-offer-megaphone-white-background-ribbon-discount-sale-modern-advertising-promotion-store-info-174333995.jpg",
                "https://cdn.create.vista.com/downloads/50bd42e2-7c5b-42c7-b0a7-393e534995f0_640.jpeg"
            ),
            products = mockProductsData
        )
    ), PageProduct.PageSpecialOffer(
        specialOffer = SpecialOffer(
            offerType = SpecialOfferType.DEAL_OF_DAY,
            contentTitle = "Deal of the Day!",
            contentDescription = "",
            contentBackgroundColor = DodgerBlue,
            products = mockProductsData
        )
    ),

    PageProduct.ProductList(
        productListType = ProductListType.PAGER,
        products = mockProductsData,
    ),

    PageProduct.PageSpecialOffer(
        specialOffer = SpecialOffer(
            offerType = SpecialOfferType.IMAGE_WITH_TEXT,
            contentTitle = "New Arrivals",
            contentDescription = "Summer’ 25 Collections",
            imageUrl = listOf("https://s3-alpha-sig.figma.com/img/f3ea/6b0e/b8c7849710cbe962e5c0069216c1d0ac?Expires=1736121600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=HgIjamOet841H92a7rG7YzGExIaZEgzxk73FJem7beej8Vtpu8a1Gf38BTkpzfwN-WiyZ8KeDIqLO3yv075upRPKk74UD4LKU9GSz3TfvBFyvE8otCrtRZCJRYjxRB3plZY05KtoXC~mrhRVIf2tJ-eMDaHLmJrm8~5evCdWhkY7CwCuWnu~UOlBEpDMkW0vb7j8MX-mpBxH~Oun1tHoI1X2eK6HriDwHKLyd3diy6eKKwz6gsVEJfGRY3bQbXYJ~N0424imveOlHyoPpomC6SNs9dqi4vCAN8AFRBAkBE1IFi9ya2tnMS7YijwrZxluQemNBcppJO1Yh-1VhNG94g__"),
            products = mockProductsData
        )
    ),
    PageProduct.ProductList(
        productListType = ProductListType.PAGER,
        products = mockProductsShortData,
    ),
    PageProduct.PageSpecialOffer(
        specialOffer = SpecialOffer(
            offerType = SpecialOfferType.IMAGE_WITH_TEXT,
            contentTitle = "Up to 50% Off",
            contentDescription = "",
            imageUrl = listOf("https://s3-alpha-sig.figma.com/img/7332/768b/30b075af733efdfac968c94f0be6768b?Expires=1736121600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=j22Xb4vc0i8Eh26t9Bdv5HMosCXCIz8UtAqB1U98VrdWRwY9fTopWmk93onIfSgd1JHP9zjf7AzL7I6KEPQur38FxaaLFPls5Ra9hqIeq6phNdfflO1bp-3-Jt6qD9I2W0JRzo2r7fugjC-hHb-H8WGCXobIh7~xPyII6Vip6C716CZza9RLTTVV~tZhxrAOydoid23FfU-FFU6S0pOZ5PC6ZkRMNG1SMHM1~HGl0u5tQUmqsLgrmIIrdfTXw9mnAt63vrFsCvpPFCWvVb1EyAYgQm9F7fPU5lYm9Xe6RjfqAjekZnBZrJc2D~L-Q2iC~LE6k3I7pOEH7MiLQBL9UQ__"),
            products = mockProductsData
        )
    )
)
