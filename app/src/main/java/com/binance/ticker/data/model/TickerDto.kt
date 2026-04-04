package com.binance.ticker.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TickerDto(
    @Json(name = "symbol") val symbol: String,
    @Json(name = "priceChange") val priceChange: String,
    @Json(name = "priceChangePercent") val priceChangePercent: String,
    @Json(name = "weightedAvgPrice") val weightedAvgPrice: String,
    @Json(name = "prevClosePrice") val prevClosePrice: String,
    @Json(name = "lastPrice") val lastPrice: String,
    @Json(name = "lastQty") val lastQty: String,
    @Json(name = "bidPrice") val bidPrice: String,
    @Json(name = "bidQty") val bidQty: String,
    @Json(name = "askPrice") val askPrice: String,
    @Json(name = "askQty") val askQty: String,
    @Json(name = "openPrice") val openPrice: String,
    @Json(name = "highPrice") val highPrice: String,
    @Json(name = "lowPrice") val lowPrice: String,
    @Json(name = "volume") val volume: String,
    @Json(name = "quoteVolume") val quoteVolume: String,
    @Json(name = "openTime") val openTime: Long,
    @Json(name = "closeTime") val closeTime: Long,
    @Json(name = "firstId") val firstId: Long,
    @Json(name = "lastId") val lastId: Long,
    @Json(name = "count") val count: Long
)