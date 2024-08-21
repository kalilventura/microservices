package br.com.github.kalilventura.salesapi.orders.domain.entities

import br.com.github.kalilventura.salesapi.products.domain.entities.Product
import java.time.LocalDateTime

class Order private constructor(
    val status: Status,
    val user: String,
    val createdAt: LocalDateTime,
    val transactionId: String,
    val discount: Double,
    val products: List<Product>) {

    fun totalAmount(): Double {
        val totalValue = products.sumOf { product -> product.unitPrice * product.quantity }
        return totalValue - discount
    }

    data class Builder(
        var status: Status = Status.PENDING,
        var user: String = "",
        var createdAt: LocalDateTime = LocalDateTime.now(),
        var transactionId: String = "",
        var discount: Double = 0.0,
        var products: List<Product> = emptyList()) {

        fun status(status: Status) = apply { this.status = status }
        fun user(user: String) = apply { this.user = user }
        fun createdAt(createdAt: LocalDateTime) = apply { this.createdAt = createdAt }
        fun transactionId(transactionId: String) = apply { this.transactionId = transactionId }
        fun products(products: List<Product>) = apply { this.products = products }
        fun discount(discount: Double) = apply {this.discount = discount }

        fun build() = Order(status, user, createdAt, transactionId, discount, products)
    }
}
