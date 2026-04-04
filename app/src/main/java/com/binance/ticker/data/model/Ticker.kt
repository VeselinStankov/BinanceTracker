package com.binance.ticker.data.model

import com.binance.ticker.data.local.TickerEntity

data class Ticker(
    val symbol: String,
    val priceChange: String,
    val priceChangePercent: String,
    val weightedAvgPrice: String,
    val prevClosePrice: String,
    val lastPrice: String,
    val lastQty: String,
    val bidPrice: String,
    val bidQty: String,
    val askPrice: String,
    val askQty: String,
    val openPrice: String,
    val highPrice: String,
    val lowPrice: String,
    val volume: String,
    val quoteVolume: String,
    val openTime: Long,
    val closeTime: Long,
    val firstId: Long,
    val lastId: Long,
    val count: Long
) {
    fun toPropertyList(): List<Pair<String, String>> = listOf(
        "Symbol" to symbol,
        "Price Change" to priceChange,
        "Price Change Percent" to "$priceChangePercent%",
        "Weighted Avg Price" to weightedAvgPrice,
        "Prev Close Price" to prevClosePrice,
        "Last Price" to lastPrice,
        "Last Qty" to lastQty,
        "Bid Price" to bidPrice,
        "Bid Qty" to bidQty,
        "Ask Price" to askPrice,
        "Ask Qty" to askQty,
        "Open Price" to openPrice,
        "High Price" to highPrice,
        "Low Price" to lowPrice,
        "Volume" to volume,
        "Quote Volume" to quoteVolume,
        "Open Time" to openTime.toString(),
        "Close Time" to closeTime.toString(),
        "First Id" to firstId.toString(),
        "Last Id" to lastId.toString(),
        "Count" to count.toString()
    )
}

fun TickerDto.toEntity() = TickerEntity(
    symbol = symbol,
    priceChange = priceChange,
    priceChangePercent = priceChangePercent,
    weightedAvgPrice = weightedAvgPrice,
    prevClosePrice = prevClosePrice,
    lastPrice = lastPrice,
    lastQty = lastQty,
    bidPrice = bidPrice,
    bidQty = bidQty,
    askPrice = askPrice,
    askQty = askQty,
    openPrice = openPrice,
    highPrice = highPrice,
    lowPrice = lowPrice,
    volume = volume,
    quoteVolume = quoteVolume,
    openTime = openTime,
    closeTime = closeTime,
    firstId = firstId,
    lastId = lastId,
    count = count
)

fun TickerEntity.toDomain() = Ticker(
    symbol = symbol,
    priceChange = priceChange,
    priceChangePercent = priceChangePercent,
    weightedAvgPrice = weightedAvgPrice,
    prevClosePrice = prevClosePrice,
    lastPrice = lastPrice,
    lastQty = lastQty,
    bidPrice = bidPrice,
    bidQty = bidQty,
    askPrice = askPrice,
    askQty = askQty,
    openPrice = openPrice,
    highPrice = highPrice,
    lowPrice = lowPrice,
    volume = volume,
    quoteVolume = quoteVolume,
    openTime = openTime,
    closeTime = closeTime,
    firstId = firstId,
    lastId = lastId,
    count = count
)