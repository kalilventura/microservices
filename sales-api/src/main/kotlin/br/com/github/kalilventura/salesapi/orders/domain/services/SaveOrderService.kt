package br.com.github.kalilventura.salesapi.orders.domain.services

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order

interface SaveOrderService {
    fun save(order: Order): Order
}