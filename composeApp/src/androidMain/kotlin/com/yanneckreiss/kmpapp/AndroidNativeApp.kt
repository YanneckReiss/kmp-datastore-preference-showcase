package com.yanneckreiss.kmpapp

import android.app.Application
import com.yanneckreiss.kmpapp.common.injection.androidNativeKoinModules
import com.yanneckreiss.kmpapp.common.di.initKoin
import com.yanneckreiss.kmpapp.domain.IncrementAppOpeningCounterUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AndroidNativeApp : Application(), KoinComponent {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val incrementAppOpeningCounterUseCase by inject<IncrementAppOpeningCounterUseCase>()

    override fun onCreate() {
        super.onCreate()

        initKoin(androidNativeKoinModules)

        trackAppStartup()
    }

    private fun trackAppStartup() {
        scope.launch {
            incrementAppOpeningCounterUseCase.call()
        }
    }
}
