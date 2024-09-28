package br.com.github.kalilventura.salesapi.orders.infrastructure.controllers

import br.com.github.kalilventura.salesapi.global.infrastructure.Result
import br.com.github.kalilventura.salesapi.orders.domain.commands.FindOrderByIdCommand
import br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.responses.OrderResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${api.v1.endpoint-prefix}")
class FindOrderByIdController(val command: FindOrderByIdCommand) {

    @GetMapping("/orders/{id}")
    fun execute(@PathVariable("id") orderId: String): ResponseEntity<OrderResponse> {
        return when (val result = command.execute(orderId)) {
            is Result.Success -> {
                ResponseEntity.ok(OrderResponse.toResponse(result.data))
            }
            is Result.Error -> {
                ResponseEntity.badRequest().build()
            }
        }
    }
}
