package br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.requests

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.mappers.OrderMapper
import br.com.github.kalilventura.salesapi.products.infrastructure.controllers.requests.ProductRequest

class CreateOrderRequest(val products: List<ProductRequest>) {

    fun toDomain() : Order {
        return OrderMapper.mapToEntity(this)
    }
}
