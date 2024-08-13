package br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.models

import br.com.github.kalilventura.salesapi.products.infrastructure.repositories.models.ProductSchema
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collation = "orders")
data class OrderSchema (
    @Id val id: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val transactionId: String,
    val serviceId: String,
    val items: List<ProductSchema>
)
