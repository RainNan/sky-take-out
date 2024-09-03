package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {


    List<Long> getSetmealIdsByDishIds(List<Long> DishIds);

    /**
     * 新增套餐与菜品的关系
     *
     * @param setmealDishes
     */
    void addSetWithDish(List<SetmealDish> setmealDishes);
}
