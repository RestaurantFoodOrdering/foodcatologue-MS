package com.support.Foodcatolog.controller;
import com.support.Foodcatolog.dto.FoodItemDto;
import com.support.Foodcatolog.dto.Foodcatologpage;
import com.support.Foodcatolog.service.FoodcatologService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
public class FoodcatologcontrollerTest {

    @Mock
    private FoodcatologService foodCatalogueService;

    @InjectMocks
    private Foodcatologcontroller foodCatalogueController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addFoodItem_ShouldReturnCreatedStatus() {
        // Arrange
        FoodItemDto foodItemDTO = new FoodItemDto();
        when(foodCatalogueService.addFoodItemInDb(any(FoodItemDto.class))).thenReturn(foodItemDTO);

        // Act
        ResponseEntity<FoodItemDto> response = foodCatalogueController.addRestaurant(foodItemDTO);

        // Assert
        verify(foodCatalogueService, times(1)).addFoodItemInDb(foodItemDTO);
        assert response.getStatusCode() == HttpStatus.CREATED;
        assert response.getBody() == foodItemDTO;
    }

    @Test
    void fetchRestauDetailsWithFoodMenu_ShouldReturnOkStatus() {
        // Arrange
        int restaurantId = 123;
        Foodcatologpage foodCataloguePage = new Foodcatologpage();
        when(foodCatalogueService.fetchfoodcatologpagedetails(restaurantId)).thenReturn(foodCataloguePage);

        // Act
        ResponseEntity<Foodcatologpage> response = foodCatalogueController.fetchRestaurantDetailswithFoodmenu(restaurantId);

        // Assert
        verify(foodCatalogueService, times(1)).fetchfoodcatologpagedetails(restaurantId);
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == foodCataloguePage;
    }
}
