package com.clibchina.shopping.service;

import com.clibchina.shopping.dao.ShopOrderDao;
import com.clibchina.shopping.dao.ShopOrderGoodsMappingDao;
import com.clibchina.shopping.domain.ShopOrder;
import com.clibchina.shopping.domain.ShopOrderGoodsMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderGoodsMappingService {

    @Autowired
    ShopOrderGoodsMappingDao shopOrderGoodsMappingDao;

    public List<ShopOrderGoodsMapping> getAllShopOrderGoodsMapping() {
        List<ShopOrderGoodsMapping> shopOrderGoodsMappings = shopOrderGoodsMappingDao.queryAllShopOrderGoodsMapping();
        return shopOrderGoodsMappings;
    }

    public ShopOrderGoodsMapping getShopOrderGoodsMapping(int id) {
        ShopOrderGoodsMapping shopOrderGoodsMapping = shopOrderGoodsMappingDao.queryShopOrderGoodsMapping(id);
        return shopOrderGoodsMapping;
    }

    public List<ShopOrderGoodsMapping> getShopOrderGoodsMappingByOrderId(int orderId) {
        List<ShopOrderGoodsMapping> shopOrderGoodsMappings = shopOrderGoodsMappingDao.queryShopOrderGoodsMappingByOrderId(orderId);
        return shopOrderGoodsMappings;
    }

    public void addShopOrderGoodsMapping(ShopOrderGoodsMapping shopOrderGoodsMapping) {
        shopOrderGoodsMappingDao.addShopOrderGoodsMapping(shopOrderGoodsMapping);
    }

    public void deleteShopOrderGoodsMapping(int id) {
        shopOrderGoodsMappingDao.deleteShopOrderGoodsMapping(id);
    }

    public void updateShopOrderGoodsMapping(ShopOrderGoodsMapping shopOrderGoodsMapping) {
        shopOrderGoodsMappingDao.updateShopOrderGoodsById(shopOrderGoodsMapping);
    }
}
