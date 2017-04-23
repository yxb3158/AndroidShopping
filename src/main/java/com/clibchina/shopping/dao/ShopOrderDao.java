package com.clibchina.shopping.dao;

import com.clibchina.shopping.domain.ShopOrder;
import com.clibchina.shopping.domain.ShopType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.ResultSetType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShopOrderDao {

    final String INSERT_KEYS = "user_id, name, status, total_price, address, note, phone, send_time, ctime, utime, sign, is_diy, msg";
    final String INSERT_VALUES = "#{userId}, #{name}, #{status}, #{totalPrice}, #{address}, #{note}, #{phone}, #{sendTime}, #{ctime}, #{utime}, #{sign}, #{isDiy}, #{msg}";
    final String SELECT_KEYS = "id, " + INSERT_KEYS;

    @Insert("INSERT INTO shop_order (" + INSERT_KEYS + ") VALUES " + "(" + INSERT_VALUES + ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int addShopOrder(ShopOrder shopOrder);

    @Select("select " + SELECT_KEYS + " from shop_order where id = #{id}")
    public ShopOrder queryShopOrderById(int id);

    @Select("select " + SELECT_KEYS + " from shop_order where user_id = #{userId} order by id desc")
    public List<ShopOrder> queryShopOrderByUserId(@Param("userId") int userId);

    @Select("select * from shop_order order by id desc")
    public List<ShopOrder> queryAllShopOrder();

    @Select("select * from shop_order where status = #{status} and sign = 0 order by id desc")
    public List<ShopOrder> queryShopOrderByStatus(@Param("status") int status);

    @Update("update shop_order set status = #{status} where id = #{id}")
    public void updateShopOrderStatusById(@Param("id") int id, @Param("status") int status);

    @Update("update shop_order set sign = #{sign} where id = #{id}")
    public void updateShopOrderSignById(@Param("id") int id, @Param("sign") int sign);

    @Delete("delete from shop_order where id = #{id}")
    public void deleteShopOrder(int id);
}
