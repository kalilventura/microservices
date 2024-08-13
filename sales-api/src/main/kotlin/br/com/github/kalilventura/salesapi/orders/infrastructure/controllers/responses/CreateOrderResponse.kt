package br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.responses

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.mappers.OrderMapper

class CreateOrderResponse(
    val transactionId: String?,
    val status: String) {
    companion object {
        fun toResponse(order: Order): CreateOrderResponse {
            return OrderMapper.mapToResponse(order)
        }
    }
}
