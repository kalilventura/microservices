package br.com.github.kalilventura.salesapi.orders.infrastructure.controllers

import br.com.github.kalilventura.salesapi.global.infrastructure.Result
import br.com.github.kalilventura.salesapi.orders.domain.commands.SaveOrderCommand
import br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.requests.CreateOrderRequest
import br.com.github.kalilventura.salesapi.orders.infrastructure.controllers.responses.CreateOrderResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${api.v1.endpoint-prefix}")
class SaveOrderController(val command: SaveOrderCommand) {

    @PostMapping("/orders")
    fun execute(@RequestBody request: CreateOrderRequest): ResponseEntity<CreateOrderResponse> {
        return when (val result = command.execute(request.toDomain())) {
            is Result.Success -> {
                ResponseEntity(CreateOrderResponse.toResponse(result.data), HttpStatus.CREATED)
            }
            is Result.Error -> {
                ResponseEntity.badRequest().build()
            }
        }
    }
}