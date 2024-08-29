package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    /**
     * 新增菜品，不光加入 菜品表 dish 还有 口味表 dish flavor
     *
     * @param dishDTO
     */
    // 事务注解，要么同时成功，要么同时失败
    @Transactional
    public void add(DishDTO dishDTO) {
        /*
        向 菜品表 插入 1 条菜品数据，但是还有 n 条口味数据
         */
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);

        //TODO 公共字段自动填充
        dish.setCreateTime(LocalDateTime.now());
        dish.setCreateUser(BaseContext.getCurrentId());
        dish.setUpdateTime(LocalDateTime.now());
        dish.setUpdateUser(BaseContext.getCurrentId());

        dishMapper.add(dish);

        /*
          向 口味表 插入 n 条数据
         */

        // 获取 insert 语句生成的主键值
        Long dishId = dish.getId();
        List<DishFlavor> flavors = dishDTO.getFlavors();
        // 判断非空
        if (flavors != null && !flavors.isEmpty()) {
            flavors.forEach(flavor -> {
                flavor.setDishId(dishId);
            });
            dishFlavorMapper.add(flavors);
        }


    }
}
