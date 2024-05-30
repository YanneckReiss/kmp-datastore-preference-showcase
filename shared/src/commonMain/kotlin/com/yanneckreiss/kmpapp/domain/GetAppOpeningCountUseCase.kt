package com.yanneckreiss.kmpapp.domain

import com.yanneckreiss.kmpapp.data.KeyValueStore

class GetAppOpeningCountUseCase(
    private val keyValueStore: KeyValueStore
) {

    suspend fun call(): Int = keyValueStore.getAppOpeningCounter()
}
