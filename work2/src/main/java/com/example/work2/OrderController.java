package com.example.work2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class OrderController {

    @GetMapping("/process")
    public Mono<String> process() {
        return Mono.just("Hello");
    }

}
