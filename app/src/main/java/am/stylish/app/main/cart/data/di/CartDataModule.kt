package am.stylish.app.main.cart.data.di

import am.stylish.app.common_data.dao.CartDao
import am.stylish.app.common_data.database.CartDatabase
import am.stylish.app.main.cart.data.repository.CartRepositoryImpl
import am.stylish.app.main.cart.domain.repository.CartRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val cartDataModule = module {
    factoryOf(::CartRepositoryImpl) { bind<CartRepository>() }

    factory<CartDao> { get<CartDatabase>().cartDao() }
}