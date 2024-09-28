package br.com.github.kalilventura.salesapi.orders.infrastructure.producers

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order
import br.com.github.kalilventura.salesapi.orders.domain.services.SendMessageService
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class ProductPublisher(val template: RabbitTemplate): SendMessageService {

    override fun execute(order: Order) {
        val exchange = ""
        template.convertAndSend(exchange, order)
    }
}