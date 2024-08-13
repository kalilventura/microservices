package br.com.github.kalilventura.salesapi.orders.infrastructure.repositories

import br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.contracts.OrdersRepository
import br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.models.OrderSchema
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
public interface OrdersSchemaRepository: OrdersRepository, MongoRepository<OrderSchema, String>