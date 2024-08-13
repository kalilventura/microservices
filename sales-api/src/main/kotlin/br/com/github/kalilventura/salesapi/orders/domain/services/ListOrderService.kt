package br.com.github.kalilventura.salesapi.orders.domain.services

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import java.util.Optional

interface ListOrderService {
    fun findById(id: String): Optional<Order>
}