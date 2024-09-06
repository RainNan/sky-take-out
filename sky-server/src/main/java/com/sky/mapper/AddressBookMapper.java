package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressBookMapper {
    /**
     * 新增地址
     *
     * @param addressBook
     */
    @Insert("insert into sky_take_out.address_book" +
            "(user_id, consignee, sex, phone, province_code, province_name, city_code, city_name, district_code, district_name, detail, label,is_default)" +
            "values " +
            "(#{userId}, #{consignee}, #{sex},#{phone}, #{provinceCode}, #{provinceName}, #{cityCode}, #{cityName}, #{districtCode}, #{districtName}, #{detail}, #{label}, #{isDefault})")
    void save(AddressBook addressBook);

    /**
     * 查询地址
     *
     * @return
     */
// 这里应该条件查询，代码复用
//    @Select("select * from sky_take_out.address_book")
    List<AddressBook> list();

    /**
     * 查询默认地址
     *
     * @return
     */
    @Select("select * from sky_take_out.address_book where is_default = 1")
    AddressBook getDefault();

    /**
     * 修改地址
     *
     * @param addressBook
     */
    void update(AddressBook addressBook);

    /**
     * 根据id删除地址
     *
     * @param id
     */
    @Delete("delete from sky_take_out.address_book where id = #{id}")
    void deleteById(Long id);

    /**
     * 根据id查询地址
     *
     * @param id
     * @return
     */
    @Select("select * from sky_take_out.address_book where id = #{id}")
    AddressBook getById(Long id);


    /**
     * 根据 用户id修改 是否默认地址
     *
     * @param addressBook
     */
    @Update("update sky_take_out.address_book set is_default = #{isDefault} where user_id = #{userId}")
    void updateIsDefaultByUserId(AddressBook addressBook);
}
