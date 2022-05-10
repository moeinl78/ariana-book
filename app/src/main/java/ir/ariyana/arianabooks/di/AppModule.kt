package ir.ariyana.arianabooks.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.ariyana.arianabooks.repository.local.BookDao
import ir.ariyana.arianabooks.repository.local.BookDatabase
import ir.ariyana.arianabooks.repository.remote.ServiceAPI
import ir.ariyana.arianabooks.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // RETROFIT INSTANCE
    @Provides
    @Singleton
    fun provideRetrofitAPI(): ServiceAPI =
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceAPI::class.java)

    // DATABASE INSTANCE TO ACCESS BOOK DAO
    @Provides
    @Singleton
    fun provideBookDAO(@ApplicationContext context: Context): BookDao =
        BookDatabase
            .createDatabase(context)
            .bookDao
}