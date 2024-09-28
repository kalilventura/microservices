package br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.requests

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.domain.entities.Status
import br.com.github.kalilventura.salesapi.orders.domain.entities.Product
import java.time.LocalDateTime
import java.util.*

data class CreateOrderRequest(val products: List<ProductRequest>, val discount: Double) {
    fun toDomain() : Order {
        val products = this.products.map { req -> Product(req.id, req.quantity, req.unitPrice) }
        return Order.Builder()
            .createdAt(LocalDateTime.now())
            .status(Status.PENDING)
            .transactionId(UUID.randomUUID().toString())
            .products(products)
            .discount(discount)
            .build()
    }
}
