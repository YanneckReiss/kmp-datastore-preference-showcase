package com.yanneckreiss.kmpapp.common.di

import com.yanneckreiss.kmpapp.data.KeyValueStore
import com.yanneckreiss.kmpapp.data.createDataStore
import com.yanneckreiss.kmpapp.data.keyValueStorePath
import com.yanneckreiss.kmpapp.domain.GetAppOpeningCountUseCase
import com.yanneckreiss.kmpapp.domain.IncrementAppOpeningCounterUseCase
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

private val dataModule = module {
    single { createDataStore { keyValueStorePath() } }
    factory { KeyValueStore(get()) }
}

private val useCaseModule = module {
    factoryOf(::IncrementAppOpeningCounterUseCase)
    factoryOf(::GetAppOpeningCountUseCase)
}

fun initKoin() {
    initKoin(listOf())
}

fun initKoin(extraModules: List<Module>) {
    startKoin {
        modules(
            dataModule,
            useCaseModule,
            *extraModules.toTypedArray(),
        )
    }
}
