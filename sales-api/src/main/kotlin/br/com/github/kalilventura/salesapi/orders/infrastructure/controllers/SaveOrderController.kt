package br.com.github.kalilventura.salesapi.orders.infrastructure.controllers

import br.com.github.kalilventura.salesapi.global.infrastructure.ResponseHolder
import br.com.github.kalilventura.salesapi.orders.domain.commands.SaveOrderCommand
import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
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
        val wrapper = ResponseHolder<CreateOrderResponse>()

        val listeners = SaveOrderCommand.Listeners(
            {order -> onSuccess(order, wrapper)},
            {onError(wrapper)}
        )

        command.execute(request.toDomain(), listeners)
        return wrapper.response
    }

    fun onSuccess(order: Order, wrapper: ResponseHolder<CreateOrderResponse>) {
        wrapper.response = ResponseEntity(CreateOrderResponse.toResponse(order), HttpStatus.CREATED)
    }

    fun onError(wrapper: ResponseHolder<CreateOrderResponse>) {
        wrapper.response = ResponseEntity.badRequest().build()
    }
}