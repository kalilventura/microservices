package br.com.github.kalilventura.salesapi.orders.infrastructure.controllers

import br.com.github.kalilventura.salesapi.orders.domain.commands.FindOrderByIdCommand
import br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.responses.OrderResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("\${api.v1.endpoint-prefix}")
class FindOrderByIdController(val command: FindOrderByIdCommand) {

    @GetMapping("/orders/{id}")
    fun execute(@PathVariable("id") orderId: String): ResponseEntity<OrderResponse> {
        val order = command.execute(orderId)
        return order.map {
            ResponseEntity.ok().body(OrderResponse())
        } .orElseGet {
            ResponseEntity.noContent().build<OrderResponse>();
        }
    }

}
