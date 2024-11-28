package am.stylish.app.main.home

import am.stylish.app.R
import am.stylish.app.common_domain.model.product.Product
import am.stylish.app.common_domain.model.special_offer.SpecialOffer
import am.stylish.app.common_presentation.components.search.SearchBar
import am.stylish.app.common_presentation.components.action_bar.AppActionBar
import am.stylish.app.common_presentation.components.button.IconButton
import am.stylish.app.common_presentation.components.product_list.ProductListWithSpecialOffers
import am.stylish.app.common_presentation.components.text.AppLogoWithText
import am.stylish.app.common_presentation.ui.theme.ActionBarLogoTextStyle
import am.stylish.app.common_presentation.utils.test_mock_data.mockPageProductData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit = {},
    onSpecialOfferClick: (SpecialOffer) -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFDFD))
            .verticalScroll(scrollState)
    ) {
        AppActionBar(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            showCenterContent = true,
            showStartContent = true,
            showEndContent = true,
            centerContent = {
                AppLogoWithText(
                    textStyle = ActionBarLogoTextStyle, iconHeight = 32
                )
            },
            startContent = {
                IconButton(icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_menu), contentDescription = null
                    )
                }) { }
            },
            endContent = {
                Image(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    painter = painterResource(R.drawable.ic_default_profile_placeholder),
                    contentDescription = null
                )
            })

        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            text = stringResource(R.string.search_any_product),
        )

        ProductListWithSpecialOffers(
            modifier = modifier.fillMaxSize(),
            products = mockPageProductData,
            onProductClick = onProductClick,
            onSpecialOfferClick = {
                onSpecialOfferClick(it.specialOffer)
            },
        )

    }
}