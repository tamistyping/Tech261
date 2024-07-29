package com.sparta.tp.webclientapi.controllers;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sparta.tp.webclientapi.model.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class SimpleApiCallController {

    private final WebClient webClient;

    public SimpleApiCallController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping()
    public String welcome() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.postcodes.io/")
                .build();

        String response = webClient.get().uri("postcodes/e162hu").retrieve().bodyToMono(String.class).block();

        return response;
    }

}
