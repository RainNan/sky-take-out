package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 注意 Mapper 层是接口
@Mapper
public interface CategoryMapper {

    /**
     * 修改分类
     *
     * @param category
     */
    void update(Category category);

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 启用禁用分类
     *
     * @param status
     * @param id
     */
    @Update("update sky_take_out.category set status = #{status} where id = #{id}")
    void startOrStop(Integer status, Long id);

    /**
     * 新增分类
     *
     * @param category
     */
    @Insert("insert into sky_take_out.category (type, name, sort, create_time, update_time, create_user, update_user) " +
            "VALUES (#{type},#{name},#{sort},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void add(Category category);

    /**
     * 根据 id 删除分类
     *
     * @param id
     */
    @Delete("delete from sky_take_out.category where id = #{id}")
    void delete(Long id);

    /**
     * 根据类型查询分类
     *
     * @param type
     * @return
     */
    Category getByType(Integer type);

    /**
     * 根据类型查询分类
     *
     * @param type
     * @return
     */
//    @Select("select * from sky_take_out.category where type = #{type}")
    List<Category> list(Integer type);
}
