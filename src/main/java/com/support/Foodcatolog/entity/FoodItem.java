package com.support.Foodcatolog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String foodname;
    private String fooddescription;
    private boolean isVeg;
    private BigDecimal price;
    private Integer restaurantid;
    @Column(nullable = false,columnDefinition = "INT DEFAULT 0")
    private int quantity;
}
