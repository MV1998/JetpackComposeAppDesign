package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.ui

import kotlinx.serialization.Serializable


@Serializable
object ReportScreenRoute

@Serializable
data class ProductAddEditScreenRoute(val reportId : Int)

@Serializable
data class MergeReportScreenRoute(val reportId: Int)