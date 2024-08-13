package br.com.github.kalilventura.salesapi.global.infrastructure
import org.springframework.http.ResponseEntity

class ResponseHolder<T> {

    var response: ResponseEntity<T>
        get() {
            return response;
        }
        set(value) {}
}