package br.com.github.kalilventura.salesapi.orders.infrastructure.services

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.domain.services.SaveOrderService
import br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.contracts.OrdersRepository
import br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.models.OrderSchema
import org.springframework.stereotype.Service

@Service
class SaveOrderServiceImpl(val repository: OrdersRepository) : SaveOrderService {

    override fun save(order: Order): Order {
        val document = OrderSchema.toDocument(order)
        repository.save(document)
        return order
    }
}
