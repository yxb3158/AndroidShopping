package com.clibchina.shopping.dao;

import com.clibchina.shopping.domain.ShopType;
import com.clibchina.shopping.domain.ShopUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShopUserDao {

    final String INSERT_KEYS = "name, email, password";
    final String INSERT_VALUES = "#{name}, #{email}, #{password}";
    final String SELECT_KEYS = "id, " + INSERT_KEYS;

    @Insert("INSERT INTO shop_user (" + INSERT_KEYS + ") VALUES " + "(" + INSERT_VALUES + ")")
    @Options(useGeneratedKeys = true)
    public int addShopUser(ShopUser shopUser);

    @Select("select " + SELECT_KEYS + " from shop_user where id = #{id}")
    public ShopUser queryShopUserById(int id);

    @Select("select " + SELECT_KEYS + " from shop_user where name = #{userName}")
    public ShopUser queryShopUserByUserName(String userName);

    @Update("update shop_user set password = #{password} where id = #{id}")
    public void updateShopUserById(ShopUser shopUser);

}
