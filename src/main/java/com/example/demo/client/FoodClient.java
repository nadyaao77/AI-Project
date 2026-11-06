package com.example.demo.client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class FoodClient {
    private final RestClient client;

    public FoodClient(
            RestClient.Builder builder,
            @Value("${salling.token}") String token) {

        client = builder
                .baseUrl("https://api.sallinggroup.com")
                .defaultHeaders(headers -> headers.setBearerAuth(token))
                .build();
    }

    public String getFoodWasteByZip(String zip) {

        return client.get()
                .uri("/v1/food-waste/?zip={zip}", zip)
                .retrieve()
                .body(String.class);
    }
}

