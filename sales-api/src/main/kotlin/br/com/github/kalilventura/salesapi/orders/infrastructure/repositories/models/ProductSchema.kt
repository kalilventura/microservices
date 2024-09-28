package br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.models

import br.com.github.kalilventura.salesapi.orders.domain.entities.Product
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collation = "products")
data class ProductSchema(
    @Id
    var id: ObjectId = ObjectId(),
    var productId: Long = 0,
    var quantity: Long = 0,
    var price: Double = 0.0) {

    fun toDomain(): Product {
        return Product(productId, quantity, price)
    }

    companion object {
        fun toDocument(product: Product): ProductSchema {
            val schema = ProductSchema()
            schema.quantity = product.quantity
            schema.productId = product.id

            return schema
        }
    }
}