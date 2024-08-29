package com.sky.mapper;

import com.sky.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface DishMapper {

    /**
     * 新增菜品，不光加入 菜品表 dish 还有 口味表 dish flavor
     *
     * @param dishDTO
     */

    void add(Dish dishDTO);
}
