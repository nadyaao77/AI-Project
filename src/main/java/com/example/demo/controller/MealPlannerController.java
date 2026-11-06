package com.example.demo.controller;


import com.example.demo.client.FoodClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
    public class MealPlannerController {
        private final FoodClient foodClient;

        public MealPlannerController(FoodClient foodClient) {
            this.foodClient = foodClient;
        }

        @GetMapping("/api/offers/raw")
        public String getOffers(@RequestParam("storeId")String storeId) {
            return foodClient.fetch(storeId);
        }

    }






