package com.yanneckreiss.kmpapp.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.atomicfu.locks.SynchronizedObject
import kotlinx.atomicfu.locks.synchronized
import okio.Path.Companion.toPath

private lateinit var dataStore: DataStore<Preferences>

private val lock = SynchronizedObject()

fun createDataStore(producePath: () -> String): DataStore<Preferences> = synchronized(lock) {
    if (::dataStore.isInitialized) {
        dataStore
    } else {
        PreferenceDataStoreFactory
            .createWithPath(produceFile = { producePath().toPath() })
            .also { createdDataStore -> dataStore = createdDataStore }
    }
}

internal const val dataStoreFileName = "kmpNativeExample.preferences_pb"