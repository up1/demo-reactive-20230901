package com.example.work2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class OrderController {

    @Autowired PaymentService paymentService;

    @GetMapping("/process")
    public Mono<String> process() {
        return Mono.just("Hello");
    }
}

@Service
class PaymentService {

    void pay() {
    }

}
