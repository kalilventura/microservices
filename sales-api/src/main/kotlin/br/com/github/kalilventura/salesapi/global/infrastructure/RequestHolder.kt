package br.com.github.kalilventura.salesapi.global.infrastructure
import org.springframework.http.ResponseEntity

class ResponseHolder<T> {

    var response: ResponseEntity<T> = TODO()
        get() {
            return field
        }
        set(value) {
            field = value
        }
}