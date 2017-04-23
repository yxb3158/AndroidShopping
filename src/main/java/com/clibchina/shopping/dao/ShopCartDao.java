package com.clibchina.shopping.dao;

import com.clibchina.shopping.domain.ShopCart;
import com.clibchina.shopping.domain.ShopType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShopCartDao {

    final String INSERT_KEYS = "user_id, goods_id, num";
    final String INSERT_VALUES = "#{userId}, #{goodsId}, #{num}";
    final String SELECT_KEYS = "id, " + INSERT_KEYS;

    @Insert("INSERT INTO shop_user_cart (" + INSERT_KEYS + ") VALUES " + "(" + INSERT_VALUES + ")")
    @Options(useGeneratedKeys = true)
    public int addShopCart(ShopCart shopCart);

    @Select("select " + SELECT_KEYS + " from shop_user_cart where user_id = #{userId}")
    public List<ShopCart> queryShopCartByUserId(@Param("userId") int userId);

    @Select("select " + SELECT_KEYS + " from shop_user_cart where user_id = #{userId} and goods_id = #{goodsId}")
    public ShopCart queryShopCartByUserIdAndGoodsId(@Param("userId") int userId, @Param("goodsId") int goodsId);

    @Update("update shop_user_cart set num = #{num} where user_id = #{userId} and goods_id = #{goodsId}")
    public void updateShopCartByUserIdAndGoodsId(@Param("userId") int userId, @Param("goodsId") int goodsId, @Param("num") int num);

    @Delete("delete from shop_user_cart where user_id = #{userId} and goods_id = #{goodsId}")
    public void deleteShopCart(@Param("userId") int userId, @Param("goodsId") int goodsId);

    @Delete("delete from shop_user_cart where user_id = #{userId}")
    public void deleteShopCartByUserId(@Param("userId") int userId);
}
