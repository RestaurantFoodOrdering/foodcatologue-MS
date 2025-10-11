package com.support.Foodcatolog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private int id;
    private String address;
    private String name;
    private String city;
    private String restaurantdiscription;
}
