package com.example.coffeeserviceapplication.repository

import com.example.coffeeserviceapplication.model.Coffee
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface CoffeeRepository : ReactiveMongoRepository<Coffee, String>