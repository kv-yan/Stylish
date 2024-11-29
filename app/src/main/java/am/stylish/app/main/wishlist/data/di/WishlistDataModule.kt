package am.stylish.app.main.wishlist.data.di

import am.stylish.app.common_data.dao.WishlistDao
import am.stylish.app.common_data.database.AppDatabase
import am.stylish.app.main.wishlist.data.repository.WishedListRepositoryImpl
import am.stylish.app.main.wishlist.domain.repository.WishedListRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val wishlistDataModule = module {
    factoryOf(::WishedListRepositoryImpl) { bind<WishedListRepository>() }

    factory<WishlistDao> { get<AppDatabase>().wishedListDao() }
}