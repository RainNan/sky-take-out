package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

public interface AddressBookService {
    /**
     * 新增地址
     *
     * @param addressBook
     */
    void save(AddressBook addressBook);

    /**
     * 查询地址
     *
     * @return
     */
    List<AddressBook> list();

    /**
     * 查询默认地址
     *
     * @return
     */
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
    void deleteById(Long id);

    /**
     * 根据id查询地址
     *
     * @param id
     * @return
     */
    AddressBook getById(Long id);

    /**
     * 设置默认地址
     *
     * @param addressBook
     */
    void setDefault(AddressBook addressBook);
}
