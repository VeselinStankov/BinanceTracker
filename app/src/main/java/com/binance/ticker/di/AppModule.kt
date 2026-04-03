package com.binance.ticker.di

import android.content.Context
import androidx.room.Room
import com.binance.ticker.data.local.TickerDao
import com.binance.ticker.data.local.TickerDatabase
import com.binance.ticker.data.remote.BinanceApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        })
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideBinanceApi(client: OkHttpClient, moshi: Moshi): BinanceApi =
        Retrofit.Builder()
            .baseUrl("https://api2.binance.com/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(BinanceApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TickerDatabase =
        Room.databaseBuilder(
            context,
            TickerDatabase::class.java,
            "ticker_db"
        ).build()

    @Provides
    @Singleton
    fun provideTickerDao(db: TickerDatabase): TickerDao = db.tickerDao()
}