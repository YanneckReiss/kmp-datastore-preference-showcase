package com.yanneckreiss.kmpapp.domain

import com.yanneckreiss.kmpapp.data.KeyValueStore

class IncrementAppOpeningCounterUseCase(
    private val keyValueStore: KeyValueStore
) {

    suspend fun call() {
        var appOpeningCounter: Int = keyValueStore.getAppOpeningCounter()
        keyValueStore.saveAppOpeningCounter(++appOpeningCounter)
    }
}
