package am.stylish.app.main.wishlist.domain.di

import am.stylish.app.main.wishlist.data.repository.WishedListRepositoryImpl
import am.stylish.app.main.wishlist.domain.usecase.DeleteWishedItemUseCase
import am.stylish.app.main.wishlist.domain.usecase.DeleteWishedItemUseCaseImpl
import am.stylish.app.main.wishlist.domain.usecase.GetWishedListUseCase
import am.stylish.app.main.wishlist.domain.usecase.GetWishedListUseCaseImpl
import am.stylish.app.main.wishlist.domain.repository.WishedListRepository
import am.stylish.app.main.wishlist.domain.usecase.DeleteAllWishedItemsUseCase
import am.stylish.app.main.wishlist.domain.usecase.DeleteAllWishedItemsUseCaseImpl
import am.stylish.app.main.wishlist.domain.usecase.InsertWishedItemUseCase
import am.stylish.app.main.wishlist.domain.usecase.InsertWishedItemUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val wishlistDomainModule = module {

    factoryOf(::WishedListRepositoryImpl) { bind<WishedListRepository>() }

    factoryOf(::InsertWishedItemUseCaseImpl) { bind<InsertWishedItemUseCase>() }

    factoryOf(::DeleteWishedItemUseCaseImpl) { bind<DeleteWishedItemUseCase>() }

    factoryOf(::DeleteAllWishedItemsUseCaseImpl) { bind<DeleteAllWishedItemsUseCase>() }

    factoryOf(::GetWishedListUseCaseImpl) { bind<GetWishedListUseCase>() }

}