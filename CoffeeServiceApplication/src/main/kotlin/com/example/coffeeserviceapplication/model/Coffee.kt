package com.example.coffeeserviceapplication.model

import org.springframework.data.annotation.Id

data class Coffee(

        @Id
        val id: String? = null,

        val name: String = "Any old joe"

)
