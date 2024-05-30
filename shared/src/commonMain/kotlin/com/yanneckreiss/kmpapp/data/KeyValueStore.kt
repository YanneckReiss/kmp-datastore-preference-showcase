package com.yanneckreiss.kmpapp.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class KeyValueStore(
    private val dataStore: DataStore<Preferences>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    companion object {
        private val APP_OPENING_COUNTER = intPreferencesKey("app_opening_counter")
    }

    suspend fun saveAppOpeningCounter(counter: Int) = withContext(dispatcher) {
        dataStore.edit { preferences: MutablePreferences -> preferences[APP_OPENING_COUNTER] = counter }
    }

    suspend fun getAppOpeningCounter(defaultValue: Int = 0): Int = withContext(dispatcher) {
        dataStore
            .data
            .catch { exception: Throwable ->
                // Potentially log the error
                emit(emptyPreferences())
            }
            .map { preferences: Preferences -> preferences[APP_OPENING_COUNTER] }
            .firstOrNull()
            ?: defaultValue
    }
}
