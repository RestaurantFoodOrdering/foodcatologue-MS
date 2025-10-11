package com.support.Foodcatolog.dto;

import com.support.Foodcatolog.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foodcatologpage {
     private List<FoodItem> fooditemlist;
     private Restaurant restaurant;

    public List<FoodItem> getFooditemlist() {
        return fooditemlist;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setFooditemlist(List<FoodItem> fooditemlist) {
        this.fooditemlist = fooditemlist;
    }
}
