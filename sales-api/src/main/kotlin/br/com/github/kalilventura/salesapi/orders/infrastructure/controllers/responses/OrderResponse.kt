package br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.responses

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import java.time.LocalDateTime

data class OrderResponse(
    val status: String,
    val createdAt: LocalDateTime,
    val totalAmount: Double,
    val items: List<ProductResponse>) {
    companion object {
        fun toResponse(order: Order) : OrderResponse {
            val products = order.products.map {
                product -> ProductResponse(product.quantity, product.unitPrice)
            }
            return OrderResponse(
                order.status.toString(),
                order.createdAt,
                order.totalAmount(),
                products
            )
        }
    }
}