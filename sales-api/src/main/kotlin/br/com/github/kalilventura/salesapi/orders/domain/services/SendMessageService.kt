package br.com.github.kalilventura.salesapi.orders.domain.services

import br.com.github.kalilventura.salesapi.orders.domain.entities.Order

interface SendMessageService {
    fun execute(order: Order)
}