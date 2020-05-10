package com.example.coffeeserviceapplication.component

import com.example.coffeeserviceapplication.model.Coffee
import com.example.coffeeserviceapplication.repository.CoffeeRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.toFlux
import javax.annotation.PostConstruct

@Component
class DataLoder(
    val repo: CoffeeRepository
) {

    @PostConstruct
    fun load() = repo.deleteAll().thenMany(
        listOf("Cappuccino", "Double espresso", "Americano", "Macchiato", "Coretto")
                .toFlux()
                .map { Coffee(name = it) }
                .flatMap { repo.save(it) })
            .thenMany(repo.findAll())
            .subscribe { println(it) }
}