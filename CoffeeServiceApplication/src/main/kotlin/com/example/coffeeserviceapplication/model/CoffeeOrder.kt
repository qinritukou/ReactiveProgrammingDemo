package com.example.coffeeserviceapplication.model

import java.time.Instant

data class CoffeeOrder(
    val coffeeId: String,

    val whenOrdered: Instant
)