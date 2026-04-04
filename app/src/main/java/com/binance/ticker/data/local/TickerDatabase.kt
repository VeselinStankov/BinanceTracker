package com.binance.ticker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TickerEntity::class], version = 1, exportSchema = false)
abstract class TickerDatabase : RoomDatabase() {
    abstract fun tickerDao(): TickerDao
}