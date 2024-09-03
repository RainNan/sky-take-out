package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SetmealMapper {

    /**
     * 分页查询
     * 注意要链接查询
     *
     * @param setmealPageQueryDTO
     * @return
     */

    Page<SetmealVO> page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 新增菜品
     *
     * @param setmeal
     */
    void add(Setmeal setmeal);


}
