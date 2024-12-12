package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.di

import android.content.Context
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.InventoryDatabase
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.dao.ProductDAO
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InventoryModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = InventoryDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun provideProductDao(
        inventoryDatabase: InventoryDatabase
    ) = inventoryDatabase.getProductDao()

    @Singleton
    @Provides
    fun provideReportDao(
        inventoryDatabase: InventoryDatabase
    ) = inventoryDatabase.getReportDao()

}