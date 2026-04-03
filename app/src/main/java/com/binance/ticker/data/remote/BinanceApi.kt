package com.binance.ticker.data.remote

import com.binance.ticker.data.model.TickerDto
import retrofit2.http.GET

interface BinanceApi {

    @GET("api/v3/ticker/24hr")
    suspend fun get24hrTickers(): List<TickerDto>
}