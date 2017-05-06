package com.clibchina.shopping.service;

import com.clibchina.shopping.dao.ShopBrandDao;
import com.clibchina.shopping.dao.ShopGoodsDao;
import com.clibchina.shopping.domain.ShopBrand;
import com.clibchina.shopping.domain.ShopGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    ShopGoodsDao shopGoodsDao;

    public List<ShopGoods> getAllShopGoods() {
        List<ShopGoods> shopGoodses = shopGoodsDao.queryAllShopGoods();
        return shopGoodses;
    }

    public List<ShopGoods> getAllShopGoodsBysearch(String searchMsg) {
        List<ShopGoods> shopGoodses = shopGoodsDao.queryAllShopGoodsBysearchMsg(searchMsg);
        return shopGoodses;
    }

    public List<ShopGoods> getShopGoodsesByTypeId(int typeId) {
        List<ShopGoods> shopGoodses = shopGoodsDao.queryShopGoodsesByTypeId(typeId);
        return shopGoodses;
    }

    public ShopGoods getShopGoods(int id) {
        ShopGoods shopGoods = shopGoodsDao.queryShopGoods(id);
        return shopGoods;
    }

    public void addShopGoods(ShopGoods shopGoods) {
        shopGoodsDao.addShopGoods(shopGoods);
    }

    public void deleteShopGoods(int id) {
        shopGoodsDao.deleteShopGoods(id);
    }

    public void updateShopGoods(ShopGoods shopGoods) {
        shopGoodsDao.updateShopGoodsById(shopGoods);
    }

    public boolean reduceShopGoodsStock(int id, int num) {
        ShopGoods shopGoods = shopGoodsDao.queryShopGoods(id);
        if (shopGoods.getStock() > num) {
            shopGoodsDao.reduceShopGoodsStockById(id, num);
            shopGoods = shopGoodsDao.queryShopGoods(id);
            if (shopGoods.getStock() == 0) {
                shopGoodsDao.updateShopGoodsSignById(id, 0);
            }
            return true;
        } else {
            return false;
        }
    }
}
