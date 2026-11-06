package com.example.demo.service;

import com.example.demo.client.FoodClient;
import org.springframework.stereotype.Service;

@Service
public class MealPlannerService {
    private final FoodClient foodClient;

    public MealPlannerService(FoodClient foodClient) {
        this.foodClient = foodClient;
    }

    public String getFoodOffers(String zip) {

        String foodData = foodClient.getFoodWasteByZip(zip);

        return foodData;
    }
}
