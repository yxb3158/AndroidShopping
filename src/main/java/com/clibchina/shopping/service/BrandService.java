package com.clibchina.shopping.service;

import com.clibchina.shopping.dao.ShopBrandDao;
import com.clibchina.shopping.dao.ShopTypeDao;
import com.clibchina.shopping.domain.ShopBrand;
import com.clibchina.shopping.domain.ShopType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    ShopBrandDao shopBrandDao;

    public List<ShopBrand> getAllShopBrand() {
        List<ShopBrand> shopTypes = shopBrandDao.queryAllShopBrand();
        return shopTypes;
    }

    public void addShopBrand(ShopBrand shopBrand) {
        shopBrandDao.addShopBrand(shopBrand);
    }

    public void deleteShopBrand(int id) {
        shopBrandDao.deleteShopBrand(id);
    }

    public void updateShopBrand(ShopBrand shopBrand) {
        shopBrandDao.updateShopBrandById(shopBrand);
    }
}
