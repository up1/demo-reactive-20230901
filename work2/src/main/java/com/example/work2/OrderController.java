package com.example.work2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class OrderController {

    @Autowired ReactiveResilience4JCircuitBreakerFactory factory;
    @Autowired PaymentService paymentService;

    @GetMapping("/process")
    public Mono<String> process() {
        return factory.create("delay").run(paymentService.pay(), r -> {
            System.out.println("Error with delay ....");
            return Mono.just("Error");
        });
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
