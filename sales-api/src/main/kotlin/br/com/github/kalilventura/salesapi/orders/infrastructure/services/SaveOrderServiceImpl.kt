package br.com.github.kalilventura.salesapi.orders.infrastructure.services

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.domain.services.SaveOrderService
import br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.contracts.OrdersRepository
import br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.models.OrderSchema
import br.com.github.kalilventura.salesapi.orders.infrastructure.services.mappers.OrderMapper
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service

@Service
class SaveOrderServiceImpl(val repository: OrdersRepository) : SaveOrderService {

    override fun save(order: Order): Order {
        val mapper = Mappers.getMapper(OrderMapper::class.java)
        val document = mapper.toDocument(order)
        repository.save(document)
        return order
    }
}
