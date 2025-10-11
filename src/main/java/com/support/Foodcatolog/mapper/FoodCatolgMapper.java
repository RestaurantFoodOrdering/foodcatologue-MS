package com.support.Foodcatolog.mapper;

import com.support.Foodcatolog.dto.FoodItemDto;
import com.support.Foodcatolog.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodCatolgMapper {
    FoodCatolgMapper Instance= Mappers.getMapper(FoodCatolgMapper.class);

    public FoodItem mapFoodItemDtoToFoodItem(FoodItemDto fooditemdto);
    public FoodItemDto mapFoodItemToFoodItemDto(FoodItem fooditem);


}
