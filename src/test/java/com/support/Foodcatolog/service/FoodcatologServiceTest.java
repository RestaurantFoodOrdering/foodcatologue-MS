package com.support.Foodcatolog.service;


import com.support.Foodcatolog.dto.FoodItemDto;
import com.support.Foodcatolog.dto.Foodcatologpage;
import com.support.Foodcatolog.dto.Restaurant;
import com.support.Foodcatolog.entity.FoodItem;
import com.support.Foodcatolog.mapper.FoodCatolgMapper;
import com.support.Foodcatolog.repo.FoodcatologRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FoodcatologServiceTest {

    @Mock
    private FoodcatologRepo foodItemRepo;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private FoodcatologService foodCatalogueService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addFoodItem_ShouldSaveFoodItemAndReturnMappedDTO() {
        // Arrange
        FoodItemDto foodItemDTO = new FoodItemDto();
        FoodItem foodItem = new FoodItem();
        when(foodItemRepo.save(any(FoodItem.class))).thenReturn(foodItem);

        // Act
        FoodItemDto result = foodCatalogueService.addFoodItemInDb(foodItemDTO);

        // Assert
        verify(foodItemRepo, times(1)).save(any(FoodItem.class));
        Assertions.assertEquals(FoodCatolgMapper.Instance.mapFoodItemToFoodItemDto(foodItem), result);
    }

    @Test
    void fetchFoodCataloguePageDetails_ShouldReturnFoodCataloguePage() {
        // Arrange
        int restaurantId = 123;
        List<FoodItem> foodItemList = Arrays.asList(new FoodItem());
        Restaurant restaurant = new Restaurant();
        when(foodItemRepo.findByRestaurantid(restaurantId)).thenReturn(foodItemList);
        when(restTemplate.getForObject(anyString(), eq(Restaurant.class))).thenReturn(restaurant);

        // Act
        Foodcatologpage result = foodCatalogueService.fetchfoodcatologpagedetails(restaurantId);

        // Assert
        verify(foodItemRepo, times(1)).findByRestaurantid(restaurantId);
        verify(restTemplate, times(1)).getForObject(anyString(), eq(Restaurant.class));
        Assertions.assertEquals(foodItemList, result.getFooditemlist());
        Assertions.assertEquals(restaurant, result.getRestaurant());
    }
}
