package com.binance.ticker.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TickerDao {

    @Query("SELECT * FROM tickers ORDER BY symbol ASC")
    fun observeAll(): Flow<List<TickerEntity>>

    @Query("SELECT * FROM tickers WHERE symbol = :symbol LIMIT 1")
    suspend fun getBySymbol(symbol: String): TickerEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tickers: List<TickerEntity>)

    @Query("DELETE FROM tickers")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM tickers")
    suspend fun count(): Int
}