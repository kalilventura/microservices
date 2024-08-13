package br.com.github.kalilventura.salesapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SalesApiApplication

fun main(args: Array<String>) {
    runApplication<SalesApiApplication>(*args)
}
