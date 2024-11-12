package am.stylish.app.landing.presentation

import am.stylish.app.R
import am.stylish.app.landing.domain.model.LandingUiItem
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class LandingViewModel : ViewModel() {
    private val _description = "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit."


    private val _benefitsList = mutableStateListOf(
        LandingUiItem(
            title = "Choose Products",
            description = _description,
            icon = R.drawable.benefit_item_1
        ),
        LandingUiItem(
            title = "Make Payment",
            description = _description,
            icon = R.drawable.benefit_item_2
        ),
        LandingUiItem(
            title = "Get Your Order",
            description = _description,
            icon = R.drawable.benefit_item_3
        ),
    )

    val benefitsList: List<LandingUiItem> = _benefitsList
}
