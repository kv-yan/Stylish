package am.stylish.app.common_data.di

import am.stylish.app.common_data.database.AppDatabase
import am.stylish.app.common_data.repository.ProductsRepositoryImpl
import am.stylish.app.common_domain.repository.ProductsRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonDataModule = module {
    single<AppDatabase> {
        AppDatabase.getDatabase(context = get())
    }

    singleOf(::ProductsRepositoryImpl) { bind<ProductsRepository>() }
}

