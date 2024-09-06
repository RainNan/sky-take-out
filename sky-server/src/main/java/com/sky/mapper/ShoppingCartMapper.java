package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    /**
     * 条件查询购物车
     *
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 根据id更新菜品数量number（加一）
     *
     * @param cart
     */
    @Update("update sky_take_out.shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart cart);

    /**
     * 加入购物车
     *
     * @param shoppingCart
     */
    @Insert("insert into sky_take_out.shopping_cart" +
            "(name, image, user_id, dish_id, setmeal_id, dish_flavor, amount, create_time)" +
            "values" +
            "(#{name},#{image},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{amount},#{createTime})")
    void insert(ShoppingCart shoppingCart);

    /**
     * 查看购物车，返回所有数据
     *
     * @return
     */
    @Select("select * from sky_take_out.shopping_cart")
    List<ShoppingCart> listAll();

    /**
     * 清空购物车
     */
    @Delete("delete from sky_take_out.shopping_cart")
    void clean();
}
