package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.di

import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.repository.MergeRepositoryImpl
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.repository.ProductRepositoryImpl
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.repository.ReportRepositoryImpl
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository.MergeRepository
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository.ProductRepository
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository.ReportRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ) : ProductRepository

    @Singleton
    @Binds
    abstract fun bindsReportRepository(
        reportRepositoryImpl: ReportRepositoryImpl
    ) : ReportRepository

    @Singleton
    @Binds
    abstract fun bindsMergeRepository(
        mergeRepositoryImpl: MergeRepositoryImpl
    ) : MergeRepository
}