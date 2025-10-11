package com.support.Foodcatolog.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDto {
    private int id;
    private String foodname;
    private String fooddescription;
    private boolean isVeg;
    private BigDecimal price;
    private Integer restaurantid;

    private int quantity;
}
