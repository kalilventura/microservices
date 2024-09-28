package br.com.github.kalilventura.salesapi.orders.domain.commands

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.domain.services.ListOrderService
import org.springframework.stereotype.Component
import br.com.github.kalilventura.salesapi.global.infrastructure.Result


@Component
class FindOrderByIdCommand(val service: ListOrderService) {

    fun execute(id: String): Result<Order> {
        return try {
            Result.Success(service.findById(id).orElse(null))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}