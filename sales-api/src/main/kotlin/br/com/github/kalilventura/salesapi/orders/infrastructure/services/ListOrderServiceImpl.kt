package br.com.github.kalilventura.salesapi.orders.infrastructure.services

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.domain.services.ListOrderService
import br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.contracts.OrdersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ListOrderServiceImpl(val repository: OrdersRepository) : ListOrderService {

    override fun findById(id: String): Optional<Order> {
        val order = repository.findById(id)
        return order.map { schema -> schema.toDomain() }
    }
}