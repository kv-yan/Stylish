package am.stylish.app.special_offer_details.presentation

import am.stylish.app.common_domain.model.special_offer.SpecialOffer
import am.stylish.app.common_domain.model.special_offer.SpecialOfferType
import am.stylish.app.common_presentation.components.action_bar.AppActionBar
import am.stylish.app.common_presentation.components.product_list.ProductListStaggeredGrid
import am.stylish.app.common_presentation.ui.theme.AuthTitleTextStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpecialOfferDetailsScreen(
    modifier: Modifier = Modifier, specialOffer: SpecialOffer, onBackClick: () -> Unit = {}
) {
    Scaffold(Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            AppActionBar(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
                showCenterContent = false,
                showStartContent = true,
                showEndContent = false,
                startContent = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ) {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null
                            )

                        }
                        Text(
                            text = specialOffer.contentTitle,
                            style = AuthTitleTextStyle,
                            fontSize = 21.sp
                        )
                    }

                })
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
        specialOffer = SpecialOffer(
            offerType = SpecialOfferType.IMAGE_WITH_TEXT
        )
    )
}