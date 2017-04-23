package com.clibchina.shopping.dao;

import com.clibchina.shopping.domain.ShopBrand;
import com.clibchina.shopping.domain.ShopType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShopBrandDao {

    final String INSERT_KEYS = "name, description, ctime";
    final String INSERT_VALUES = "#{name}, #{description}, #{ctime}";
    final String SELECT_KEYS = "id, " + INSERT_KEYS;

    @Insert("INSERT INTO shop_brand (" + INSERT_KEYS + ") VALUES " + "(" + INSERT_VALUES + ")")
    @Options(useGeneratedKeys = true)
    public int addShopBrand(ShopBrand shopType);

    @Select("select " + SELECT_KEYS + " from shop_brand where id = #{id}")
    public ShopBrand queryShopBrand(int id);

    @Select("select * from shop_brand")
    public List<ShopBrand> queryAllShopBrand();

    @Update("update shop_brand set name = #{name}, description = #{description} where id = #{id}")
    public void updateShopBrandById(ShopBrand shopBrand);

    @Delete("delete from shop_brand where id = #{id}")
    public void deleteShopBrand(int id);
}
