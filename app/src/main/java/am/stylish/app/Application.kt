package am.stylish.app

import am.stylish.app.common_data.di.commonDataModule
import am.stylish.app.common_presentation.di.commonPresentationModule
import am.stylish.app.landing.presentation.di.landingPresentationModule
import am.stylish.app.main.cart.data.di.cartDataModule
import am.stylish.app.main.cart.domain.di.cartDomainModule
import am.stylish.app.main.cart.presentation.di.cartPresentationModule
import am.stylish.app.main.home.domain.di.homeDomainModule
import am.stylish.app.main.home.presentation.di.homePresentationModule
import am.stylish.app.main.wishlist.data.di.wishlistDataModule
import am.stylish.app.main.wishlist.domain.di.wishlistDomainModule
import am.stylish.app.main.wishlist.presentation.di.wishlistPresentationModule
import am.stylish.app.product_details.presentation.di.productDetailsPresentationModule
import am.stylish.app.special_offer_details.domain.di.specialOfferDetailsDomainModule
import am.stylish.app.special_offer_details.presentation.di.specialOfferDetailsPresentationModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            modules(
                commonDataModule,
                commonPresentationModule,
                landingPresentationModule,
                productDetailsPresentationModule,
                wishlistDataModule,
                wishlistDomainModule,
                wishlistPresentationModule,
                homePresentationModule,
                homeDomainModule,
                specialOfferDetailsPresentationModule,
                specialOfferDetailsDomainModule,
                cartPresentationModule,
                cartDomainModule,
                cartDataModule,
            )
        }
    }
}