package com.example.demo.service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

public class
AiService {
    private final ChatClient chatClient;

    public AiService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateMealPlan(
            String foodData,
            double budget,
            int persons,
            String preference) {

        String prompt = """
                You are an AI meal planning assistant.

                The user has the following requirements:
                Budget: %s DKK
                Number of persons: %s
                Food preference: %s

                Available food offers:
                %s

                Suggest a meal using the available food offers.
                Explain the ingredients, estimated price
                and why the meal fits the user's requirements.

                Do not invent prices that are not provided.
                If there is not enough information, say so.
                """.formatted(budget, persons, preference, foodData);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}

