package com.support.Foodcatolog.service;

import com.support.Foodcatolog.dto.FoodItemDto;

import com.support.Foodcatolog.dto.Foodcatologpage;
import com.support.Foodcatolog.dto.Restaurant;
import com.support.Foodcatolog.entity.FoodItem;
import com.support.Foodcatolog.mapper.FoodCatolgMapper;
import com.support.Foodcatolog.repo.FoodcatologRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodcatologService {
    @Autowired
    public FoodcatologRepo foodcatologRepo;
     @Autowired
     RestTemplate restTemplate;

    public  FoodItemDto addFoodItemInDb(FoodItemDto foodItemDto) {

        FoodItem foodItem=foodcatologRepo.save(FoodCatolgMapper.Instance.mapFoodItemDtoToFoodItem(foodItemDto));

        return FoodCatolgMapper.Instance.mapFoodItemToFoodItemDto(foodItem);

    }

    public Foodcatologpage fetchfoodcatologpagedetails(Integer restaurantId) {
        List<FoodItem> foodItemlist=fetchFoodItemlist(restaurantId);
       Restaurant restaurant = fetchRestaurantDetailsfromResturantId(restaurantId);
        return createFoodcatolgpage(foodItemlist, restaurant);
    }

    private Foodcatologpage createFoodcatolgpage(List<FoodItem> foodItemlist, Restaurant restaurant) {
     Foodcatologpage foodcatologpage=new Foodcatologpage();
     foodcatologpage.setFooditemlist(foodItemlist);
     foodcatologpage.setRestaurant(restaurant);
     return foodcatologpage;
    }

    private Restaurant fetchRestaurantDetailsfromResturantId(Integer restaurantId) {
       Restaurant restaurant =restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId,
               Restaurant.class);
   return restaurant;
    }

    private List<FoodItem> fetchFoodItemlist(Integer restaurantId) {
        return foodcatologRepo.findByRestaurantid(restaurantId);
    }
}
