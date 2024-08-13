package br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.contracts

import br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.models.OrderSchema

interface OrdersRepository {
    fun save(document: OrderSchema): OrderSchema
}