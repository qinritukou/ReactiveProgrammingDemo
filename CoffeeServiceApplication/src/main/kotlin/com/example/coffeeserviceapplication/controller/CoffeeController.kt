package com.example.coffeeserviceapplication.controller

import com.example.coffeeserviceapplication.service.CoffeeService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/coffees")
class CoffeeController(
    val service: CoffeeService
) {

    @GetMapping
    fun all() = service.getAllCoffess()

    @GetMapping("/{id}")
    fun byId(@PathVariable id: String) = service.getCoffeeById(id)

    @GetMapping("/{id}/orders", produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    fun orders(@PathVariable id: String) = service.getOrdersForCoffeeById(id)

}