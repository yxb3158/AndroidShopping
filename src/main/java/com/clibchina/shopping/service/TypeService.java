package com.clibchina.shopping.service;

import com.clibchina.shopping.dao.ShopTypeDao;
import com.clibchina.shopping.domain.ShopType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    ShopTypeDao shopTypeDao;

    public List<ShopType> getAllShopType() {
        List<ShopType> shopTypes = shopTypeDao.queryAllShopType();
        return shopTypes;
    }

    public ShopType getShopType(int id) {
        ShopType shopType = shopTypeDao.queryShopType(id);
        return shopType;
    }

    public void addShopType(ShopType shopType) {
        shopTypeDao.addShopType(shopType);
    }

    public void deleteShopType(int id) {
        shopTypeDao.deleteShopType(id);
    }

    public void updateShopType(ShopType shopType) {
        shopTypeDao.updateShopTypeById(shopType);
    }
}
