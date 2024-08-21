package br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.responses

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order

data class CreateOrderResponse(
    val transactionId: String?,
    val status: String) {
    companion object {
        fun toResponse(order: Order): CreateOrderResponse {
            return CreateOrderResponse(order.transactionId, order.status.toString())
        }
    }
}
