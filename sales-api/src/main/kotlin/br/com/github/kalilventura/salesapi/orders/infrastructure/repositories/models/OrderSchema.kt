package br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.models

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.domain.entities.Status
import br.com.github.kalilventura.salesapi.products.infrastructure.repositories.models.ProductSchema
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document(collation = "orders")
data class OrderSchema (
    @Id val id: ObjectId = ObjectId(),
    var status: String = "",
    var user: String = "",
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null,
    var transactionId: String = UUID.randomUUID().toString(),
    var serviceId: String = UUID.randomUUID().toString(),
    var totalAmount: Double = 0.0,
    var discount: Double = 0.0,
    var items: List<ProductSchema> = emptyList()) {

    fun toDomain(): Order {
        val status = Status.valueOf(this.status)
        val products = this.items.map { item -> item.toDomain() }
        return Order
            .Builder()
            .status(status)
            .user(user)
            .transactionId(transactionId)
            .createdAt(createdAt)
            .discount(discount)
            .products(products)
            .build()
    }

    companion object {
        fun toDocument(order: Order): OrderSchema {
            val schema = OrderSchema()
            schema.createdAt = order.createdAt
            schema.transactionId = order.transactionId
            schema.status = order.status.name
            schema.user = order.user
            schema.items = order.products.map { product -> ProductSchema.toDocument(product) }
            schema.totalAmount = order.totalAmount()
            schema.discount = order.discount

            return schema
        }
    }
}
