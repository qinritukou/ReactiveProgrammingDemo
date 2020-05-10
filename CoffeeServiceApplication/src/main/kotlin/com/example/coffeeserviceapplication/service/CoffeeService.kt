package com.example.coffeeserviceapplication.service

import com.example.coffeeserviceapplication.model.CoffeeOrder
import com.example.coffeeserviceapplication.repository.CoffeeRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.Instant

@Service
class CoffeeService(
    val repo: CoffeeRepository
) {

    fun getAllCoffess() = repo.findAll()

    fun getCoffeeById(id: String) = repo.findById(id)

    fun getOrdersForCoffeeById(coffeeId: String) = Flux.interval(Duration.ofSeconds(1))
            .onBackpressureDrop()
            .map { CoffeeOrder(coffeeId, Instant.now()) }

}