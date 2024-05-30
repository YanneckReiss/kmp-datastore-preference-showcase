package com.yanneckreiss.kmpapp.data

import splitties.init.directBootCtx

actual fun keyValueStorePath(): String {
    return directBootCtx
        .filesDir
        .resolve("datastore/$dataStoreFileName")
        .absolutePath
}
