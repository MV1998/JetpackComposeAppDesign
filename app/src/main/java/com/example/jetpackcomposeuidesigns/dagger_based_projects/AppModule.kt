package com.example.jetpackcomposeuidesigns.dagger_based_projects

import android.content.Context
import androidx.room.Room
import com.example.jetpackcomposeuidesigns.code_testing.repository_testing.DefaultShoppingRepository
import com.example.jetpackcomposeuidesigns.code_testing.repository_testing.Repository
import com.example.jetpackcomposeuidesigns.code_testing.retrofit_testing.PostAPI
import com.example.jetpackcomposeuidesigns.code_testing.room_database_testing_files.ShoppingDao
import com.example.jetpackcomposeuidesigns.code_testing.room_database_testing_files.ShoppingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context,
        ShoppingDatabase::class.java,
        "shopping_db")

    @Provides
    @Singleton
    fun provideDefaultShoppingRepository(
        shoppingDao: ShoppingDao,
        api: PostAPI
    ) = DefaultShoppingRepository(shoppingDao, api) as Repository

    @Provides
    @Singleton
    fun provideDao(
        database: ShoppingDatabase
    ) = database.shoppingDao()


    @Provides
    @Singleton
    fun providePostsAPI() = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PostAPI::class.java)

}