package br.com.github.kalilventura.salesapi.products.infrastructure.repositories

import br.com.github.kalilventura.salesapi.products.infrastructure.repositories.contracts.ProductsRepository
import br.com.github.kalilventura.salesapi.products.infrastructure.repositories.models.ProductSchema
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductsSchemaRepository: ProductsRepository, MongoRepository<ProductSchema, String>
