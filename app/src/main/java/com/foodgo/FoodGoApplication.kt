package com.foodgo

import android.app.Application
import com.foodgo.data.database.di.databaseModule
import com.foodgo.data.di.dataModule
import com.foodgo.domain.module.domainModule
import com.foodgo.feature.cart.di.cartModule
import com.foodgo.feature.menu.di.menuModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FoodGoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FoodGoApplication)
            modules(
                dataModule,
                domainModule,
                databaseModule,
                menuModule,
                cartModule
            )
        }
    }
}