package br.com.github.kalilventura.salesapi.products.infrastructure.repositories.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collation = "products")
data class ProductSchema(@Id val id: String?, val quantity: Long, val price: Double)