package br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.mappers

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.requests.CreateOrderRequest
import br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.responses.CreateOrderResponse
import br.com.github.kalilventura.salesapi.products.domain.entities.Product

class OrderMapper {

    companion object {
        fun mapToEntity(request: CreateOrderRequest): Order {
            val products = request.products.map {
                productRequest -> Product(
                productRequest.id, productRequest.quantity)
            }.toList()
            return Order
                .Builder()
                .products(products)
                .build()
        }

        fun mapToResponse(order: Order): CreateOrderResponse {
            return CreateOrderResponse(order.transactionId, order.status.toString())
        }
    }
}