package br.com.github.kalilventura.salesapi.orders.domain.commands

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.domain.services.SaveOrderService
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class SaveOrderCommand(val service: SaveOrderService) {

    fun execute(order: Order, listeners: Listeners) {
        try {
            service.save(order);
            listeners.onSuccess.accept(order);
        } catch (e: Exception) {
            listeners.onError.run();
        }
    }

    data class Listeners(val onSuccess: Consumer<Order>, val onError: Runnable)
}