package br.com.github.kalilventura.salesapi.orders.domain.entities

import br.com.github.kalilventura.salesapi.products.domain.entities.Product
import java.time.LocalDateTime

class Order private constructor(
    val status: Status?,
    val user: String?,
    val createdAt: LocalDateTime?,
    val transactionId: String?,
    val products: List<Product>?) {

    data class Builder(
        var status: Status? = null,
        var user: String? = null,
        var createdAt: LocalDateTime? = null,
        var transactionId: String? = null,
        var products: List<Product>? = null) {

        fun status(status: Status) = apply { this.status = status }
        fun user(user: String) = apply { this.user = user }
        fun createdAt(createdAt: LocalDateTime) = apply { this.createdAt = createdAt }
        fun transactionId(transactionId: String) = apply { this.transactionId = transactionId }
        fun products(products: List<Product>) = apply { this.products = products }

        fun build() = Order(status, user, createdAt, transactionId, products)
    }
}
