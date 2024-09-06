package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 新增菜品，不光加入 菜品表 dish 还有 口味表 dish flavor
     *
     * @param dishDTO
     */

    void add(Dish dishDTO);

    /**
     * 菜品分页查询
     *
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> page(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据 id 查询菜品
     *
     * @param id
     * @return
     */
    @Select("select * from sky_take_out.dish where id=#{id}")
    Dish getById(Long id);

    /**
     * 根据 id 删除菜品
     *
     * @param id
     */
    @Delete("delete from sky_take_out.dish where id = #{id}")
    void deleteById(Long id);

    void update(Dish dish);

    /**
     * 根据分类id查询菜品，要求是 status 为 1（起售）
     *
     * @param dish
     * @return
     */
    @Select("select * from sky_take_out.dish " +
            "where category_id = #{categoryId} and status = #{status}")
    List<Dish> list(Dish dish);
}
