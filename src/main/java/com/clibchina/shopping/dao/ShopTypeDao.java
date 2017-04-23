package com.clibchina.shopping.dao;

import com.clibchina.shopping.domain.ShopType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShopTypeDao {

    final String INSERT_KEYS = "type_name, description, sign";
    final String INSERT_VALUES = "#{typeName}, #{description}, #{sign}";
    final String SELECT_KEYS = "id, " + INSERT_KEYS;

    @Insert("INSERT INTO shop_type (" + INSERT_KEYS + ") VALUES " + "(" + INSERT_VALUES + ")")
    @Options(useGeneratedKeys = true)
    public int addShopType(ShopType shopType);

    @Select("select " + SELECT_KEYS + " from shop_type where id = #{id}")
    public ShopType queryShopType(int id);

    @Select("select * from shop_type")
    public List<ShopType> queryAllShopType();

    @Update("update shop_type set type_name = #{typeName}, description = #{description}, sign = #{sign} where id = #{id}")
    public void updateShopTypeById(ShopType shopType);

    @Delete("delete from shop_type where id = #{id}")
    public void deleteShopType(int id);
}
