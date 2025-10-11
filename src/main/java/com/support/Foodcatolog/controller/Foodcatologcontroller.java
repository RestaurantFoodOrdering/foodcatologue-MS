package com.support.Foodcatolog.controller;

import com.support.Foodcatolog.dto.FoodItemDto;
import com.support.Foodcatolog.dto.Foodcatologpage;
import com.support.Foodcatolog.service.FoodcatologService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodcatolog")
@CrossOrigin
public class Foodcatologcontroller {
    @Autowired
    public FoodcatologService foodcatologService;

//    @GetMapping("/fetchAllfooditems")
//    public ResponseEntity<List<FoodItemDto>> fetchAllRestaurants()
//    {
//        List<FoodItemDto> allFoodItems=foodcatologService.findALlFoodItems();
//        return new ResponseEntity<>(allFoodItems, HttpStatus.OK);
//    }

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addRestaurant(@RequestBody FoodItemDto foodItemDto)
    {
       FoodItemDto foodItemadded=foodcatologService.addFoodItemInDb(foodItemDto);
        return new ResponseEntity<>(foodItemadded, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<Foodcatologpage> fetchRestaurantDetailswithFoodmenu(@PathVariable Integer restaurantId)
    {
        Foodcatologpage foodcatologpage=foodcatologService.fetchfoodcatologpagedetails(restaurantId);
        return new ResponseEntity<>(foodcatologpage,HttpStatus.OK);
    }
}
