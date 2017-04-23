package com.clibchina.shopping.service;

import com.clibchina.shopping.dao.ShopOrderDao;
import com.clibchina.shopping.dao.ShopTypeDao;
import com.clibchina.shopping.domain.ShopOrder;
import com.clibchina.shopping.domain.ShopType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    ShopOrderDao shopOrderDao;

    public List<ShopOrder> getAllShopOrder() {
        List<ShopOrder> shopOrders = shopOrderDao.queryAllShopOrder();
        return shopOrders;
    }

    public List<ShopOrder> getShopOrderByStatus(int status) {
        List<ShopOrder> shopOrders = shopOrderDao.queryShopOrderByStatus(status);
        return shopOrders;
    }

    public ShopOrder getShopOrder(int id) {
        ShopOrder shopOrder = shopOrderDao.queryShopOrderById(id);
        return shopOrder;
    }

    public List<ShopOrder> getShopOrderByUserId(int userId) {
        List<ShopOrder> shopOrders = shopOrderDao.queryShopOrderByUserId(userId);
        return shopOrders;
    }

    public int addShopOrder(ShopOrder shopOrder) {
        return shopOrderDao.addShopOrder(shopOrder);
    }

    public void deleteShopOrder(int id) {
        shopOrderDao.deleteShopOrder(id);
    }

    public void updateShopOrder(ShopOrder shopOrder) {
        shopOrderDao.updateShopOrderStatusById(shopOrder.getId(), shopOrder.getStatus());
    }

    public void updateShopOrderSign(int orderId, int sign) {
        shopOrderDao.updateShopOrderSignById(orderId, sign);
    }
}
