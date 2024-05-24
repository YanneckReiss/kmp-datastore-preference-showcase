package com.yanneckreiss.kmpapp

import android.app.Application
import com.yanneckreiss.kmpapp.common.injection.koinModules
import com.yanneckreiss.kmpapp.di.initKoin
import org.koin.dsl.module

class AndroidNativeApp: Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        initKoin(koinModules)
    }
}
