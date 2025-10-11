package com.support.Foodcatolog.repo;

import com.support.Foodcatolog.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodcatologRepo extends JpaRepository<FoodItem,Integer> {

    List<FoodItem> findByRestaurantid(Integer restaurantId);
}
