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
            imageUrl = listOf("https://s3-alpha-sig.figma.com/img/f3ea/6b0e/b8c7849710cbe962e5c0069216c1d0ac?Expires=1734307200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=fGxamSEIW3r30i7db-oyNIIiAj2xV0RbruViJnzm-FT1eqlKc2hpXo3VlPFB5Dn7arRxpUugtFS6Te0LyAqd-ZjC5igEymrZvq4rvFsm-~d4qjwoLUcmEbSgXQO-RpwsPnjTcNaR7wkRRgCzzXztHdp48WBA9BFDbAlFnmdoE6KtGZU79CgLleV1vNKDUX6520FkiQdabZl7AublpK71p03rgCXc6C-OEl46OD1uG2lX7EDmPPwWj7aut02t~YnIk-042md3-~k-OiqhpZww2RHurpG7ZeBPZYDSFXSYdCVaH148Pg2KH1LE2aSMhVnL6aU6ZS4bC195KZZyR~19Lw__"),
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
            imageUrl = listOf("https://s3-alpha-sig.figma.com/img/7332/768b/30b075af733efdfac968c94f0be6768b?Expires=1734307200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=I9ZNBoNp~XQ5oQgnh4FCJG7QWGZiMfnQlz6O6DeC5cKRAi6UEDhXmqaXFzBB1KSita5njvS9wAokWSPzgZ3bJ33Q6XkAM8tEAId9gSY2BFuBNYRfopLTWyu0fmtygSQaK~rX5Gc4DeEQmOxxePIFPyhL90lQqiZJ25EsuusqkDSCY9FId-JGh2VQq~7EvaArXR9VN99uqWe-aDmrtLPLBm07DrdRRVI45v4YwXU4ZXfVZ5pt9kLcwhcGREKaGK-lxYMN0pBIt7TlQzQQjjCT94DPEl8lL4hR8eLBRrJN74luyc~jM-NDKSuIH2blLVqQLwTf2lCqCpvEdj1dQLTGEg__"),
            products = mockProductsData
        )
    )
)
