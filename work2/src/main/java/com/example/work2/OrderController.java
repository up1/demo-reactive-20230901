package com.example.work2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class OrderController {

    @Autowired PaymentService paymentService;

    @GetMapping("/process")
    public Mono<String> process() {
        return paymentService.pay();
    }
}

@Service
class PaymentService {

    private WebClient rest;

    public PaymentService(WebClient.Builder builder) {
        rest = builder.baseUrl("https://httpbin.org").build();
    }

    Mono<String> pay() {
        return rest.get().uri("/delay/5").retrieve().bodyToMono(String.class);
//        return Mono.just("Delay").delayElement(Duration.ofSeconds(10));
    }

}
