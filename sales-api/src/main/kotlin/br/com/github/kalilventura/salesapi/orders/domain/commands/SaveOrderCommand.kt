package br.com.github.kalilventura.salesapi.orders.domain.commands

import br.com.github.kalilventura.salesapi.global.infrastructure.Result
import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.domain.services.SaveOrderService
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class SaveOrderCommand(val service: SaveOrderService) {

    fun execute(order: Order): Result<Order> {
        return try {
            Result.Success(service.save(order))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    data class Listeners(val onSuccess: Consumer<Order>, val onError: Runnable)
}