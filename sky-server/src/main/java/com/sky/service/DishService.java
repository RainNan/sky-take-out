package com.sky.service;

import com.sky.dto.DishDTO;
import org.springframework.stereotype.Service;


public interface DishService {

    /**
     * 新增菜品，不光加入 菜品表 dish 还有 口味表 dish flavor
     *
     * @param dishDTO
     */
    void add(DishDTO dishDTO);
}
