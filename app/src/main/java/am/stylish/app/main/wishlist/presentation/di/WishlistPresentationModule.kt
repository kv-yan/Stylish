package am.stylish.app.main.wishlist.presentation.di

import am.stylish.app.main.wishlist.presentation.WishlistViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val wishlistPresentationModule = module {
    viewModelOf(::WishlistViewModel)
}