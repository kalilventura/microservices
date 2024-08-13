package br.com.github.kalilventura.salesapi.orders.infrastructure.services.mappers

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.infrastructure.repositories.models.OrderSchema
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface OrderMapper {
    fun toDocument(order: Order): OrderSchema
}