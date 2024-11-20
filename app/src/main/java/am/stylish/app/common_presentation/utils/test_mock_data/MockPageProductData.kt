package am.stylish.app.common_presentation.utils.test_mock_data

import am.stylish.app.common_domain.model.PageProduct
import am.stylish.app.common_domain.model.ProductListType
import am.stylish.app.common_domain.model.SpecialOffer
import am.stylish.app.common_domain.model.SpecialOfferType
import androidx.compose.ui.graphics.Color

val mockPageProductData = listOf(
    PageProduct.PageSpecialOffer(
        specialOffer = SpecialOffer(
            offerType = SpecialOfferType.PAGER,
            contentTitle = "Deal of the Day!",
            contentDescription = "Get up to 50% off on selected items.",
            imageUrl = listOf(
                "https://thumbs.dreamstime.com/b/red-banner-special-offer-megaphone-white-background-ribbon-discount-sale-modern-advertising-promotion-store-info-174333995.jpg",
                "https://cdn.create.vista.com/downloads/50bd42e2-7c5b-42c7-b0a7-393e534995f0_640.jpeg"
            )
        )
    ), PageProduct.PageSpecialOffer(
        specialOffer = SpecialOffer(
            offerType = SpecialOfferType.DEAL_OF_DAY,
            contentTitle = "Deal of the Day!",
            contentDescription = "",
            contentBackgroundColor = Color(0xFF4392F9),
        )
    ),

    PageProduct.ProductList(
        productListType = ProductListType.PAGER,
        products = productsMockData,
    ),

    PageProduct.PageSpecialOffer(
        specialOffer = SpecialOffer(
            offerType = SpecialOfferType.IMAGE_WITH_TEXT,
            contentTitle = "New Arrivals",
            contentDescription = "Summer’ 25 Collections",
            imageUrl = listOf("https://s3-alpha-sig.figma.com/img/f3ea/6b0e/b8c7849710cbe962e5c0069216c1d0ac?Expires=1733097600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=DP6SJIGyUQaIUGHo43fG2u4lj9URPDO49oWGSg1aKUvIk0JrmEi-OGyiCRiLphIwkW5YKhzzXo0db2NlMCrxwZwGlEKzT0Wg52OsGXlx3W7Z2-ScP56V8VQqoBxf1ydduJsIe3z~vhuJchjZX0n2DAfxeIP1iHob2t-~iozFxkGhxF09xMGvcUKPdFtuE5PW0RsmSjs4lmfEJzhDDWc61uB~GvVO6xtFPDHeDvYQrGQCpZGBAHmSE-aLUqbTcmcdwUYddyytApmJzKfX2aEBbznEEZBNAN-8KImo9Kq0W8Zp9DgOV5LsjGF4oMiv3lPspaO6t72xJuzHbUDjbxi1rg__")
        )
    ),
    PageProduct.ProductList(
        productListType = ProductListType.PAGER,
        products = productsShortMockData,
    ),
    PageProduct.PageSpecialOffer(
        specialOffer = SpecialOffer(
            offerType = SpecialOfferType.IMAGE_WITH_TEXT,
            contentTitle = "Up to 50% Off",
            contentDescription = "",
            imageUrl = listOf("https://s3-alpha-sig.figma.com/img/7332/768b/30b075af733efdfac968c94f0be6768b?Expires=1733097600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=fBlmRpN8pQhcwubUZxAMYfHXpdos1n6J3c2G~kFHYktPG0eNtYMMsy8YCvsFHBT4Ty2II~ZVL4lFAYLidP6yNPZVPocp6hVv5rPO~JKt~YSxBG3692x5TWHECYXLfOWCuSoai-z6mAXeREbuN69TB46buRqPrdqu~x~qvW4LQg7NcdiJ~jSueMTTiNGQChdqaTUdJVGeli~yQhydhPtVoCLJPIYi73JU5ju8Nb3XnunHJ5Pc7mKv25b1lSW6gjD66MmVBOFQyyNpkK60oJFQQqjUFVYuM3UeGz-8AQ79rtXn7MdmP8ehR2mPiDGOpgfSeobOhKwGURZuZraAiQG66g__")
        )
    )
)
