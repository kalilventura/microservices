package br.com.github.kalilventura.salesapi.orders.domain.commands

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.domain.services.ListOrderService
import org.springframework.data.mongodb.core.aggregation.BooleanOperators.Or
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.Optional
import java.util.function.Consumer

@Component
class FindOrderByIdCommand(val service: ListOrderService) {

    fun execute(id: String): Optional<Order> {
        return service.findById(id)
    }
}