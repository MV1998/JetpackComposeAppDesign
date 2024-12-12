package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.convertors.DateConvertors
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.dao.ProductDAO
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.dao.ReportDAO
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.entities.ProductEntity
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.entities.ReportEntity

@Database(entities = [ProductEntity::class, ReportEntity::class], version = 2)
@TypeConverters(value = [DateConvertors::class])
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun getProductDao(): ProductDAO

    abstract fun getReportDao(): ReportDAO

    companion object {
        @Volatile
        private var INSTANCE: InventoryDatabase? = null

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE 'reports' ADD COLUMN 'month' INTEGER NOT NULL DEFAULT 0;")
            }
        }

        fun getDatabase(context: Context): InventoryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InventoryDatabase::class.java,
                    "jay_inventory_system_db"
                )
                    .addMigrations(MIGRATION_1_2)
                   // .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}