package am.stylish.app.special_offer_details.presentation

import am.stylish.app.common_domain.model.SpecialOffer
import am.stylish.app.common_domain.model.SpecialOfferType
import am.stylish.app.common_presentation.components.action_bar.AppActionBar
import am.stylish.app.common_presentation.components.product_list.ProductListStaggeredGrid
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SpecialOfferDetailsScreen(
    modifier: Modifier = Modifier,
    specialOffer: SpecialOffer,
    onBackClick: () -> Unit = {}
) {
    Scaffold(Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            AppActionBar(
                modifier = Modifier
                    .fillMaxWidth(),
            )
            ProductListStaggeredGrid(
                modifier = Modifier.fillMaxSize(),
                products = specialOffer.products,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SpecialOfferDetailsScreenPreview() {
    SpecialOfferDetailsScreen(
        specialOffer =
        SpecialOffer(
            offerType = SpecialOfferType.IMAGE_WITH_TEXT
        )
    )
}