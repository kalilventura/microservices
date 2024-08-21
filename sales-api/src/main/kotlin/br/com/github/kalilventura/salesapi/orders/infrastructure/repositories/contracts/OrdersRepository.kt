package br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.contracts

import br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.models.OrderSchema
import java.util.*

interface OrdersRepository {
    fun save(document: OrderSchema): OrderSchema
    fun findById(id: String): Optional<OrderSchema>
}