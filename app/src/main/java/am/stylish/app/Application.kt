package am.stylish.app

import am.stylish.app.landing.presentation.di.landingPresentationModule
import am.stylish.app.product_details.presentation.di.productDetailsPresentationModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            modules(
                landingPresentationModule,
                productDetailsPresentationModule,
            )
        }
    }
}