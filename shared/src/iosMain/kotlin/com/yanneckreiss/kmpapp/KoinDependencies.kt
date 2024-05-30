package com.yanneckreiss.kmpapp

import com.yanneckreiss.kmpapp.domain.GetAppOpeningCountUseCase
import com.yanneckreiss.kmpapp.domain.IncrementAppOpeningCounterUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinDependencies : KoinComponent {
    val incrementAppOpeningCounterUseCase: IncrementAppOpeningCounterUseCase by inject()
    val getAppOpeningCountUseCase: GetAppOpeningCountUseCase by inject()
}
