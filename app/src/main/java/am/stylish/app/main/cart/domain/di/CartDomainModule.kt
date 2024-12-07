package am.stylish.app.main.cart.domain.di

import am.stylish.app.main.cart.domain.usecase.DeleteCartItemUseCase
import am.stylish.app.main.cart.domain.usecase.DeleteCartItemUseCaseImpl
import am.stylish.app.main.cart.domain.usecase.GetCartListUseCase
import am.stylish.app.main.cart.domain.usecase.GetCartListUseCaseImpl
import am.stylish.app.main.cart.domain.usecase.InsertCartItemUseCase
import am.stylish.app.main.cart.domain.usecase.InsertCartItemUseCaseImpl
import am.stylish.app.main.cart.domain.usecase.UpdateCartItemUseCase
import am.stylish.app.main.cart.domain.usecase.UpdateCartItemUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module


val cartDomainModule = module {

    factoryOf(::InsertCartItemUseCaseImpl) { bind<InsertCartItemUseCase>() }

    factoryOf(::UpdateCartItemUseCaseImpl) { bind<UpdateCartItemUseCase>() }

    factoryOf(::DeleteCartItemUseCaseImpl) { bind<DeleteCartItemUseCase>() }

    factoryOf(::GetCartListUseCaseImpl) { bind<GetCartListUseCase>() }

}