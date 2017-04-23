package com.clibchina.shopping.service;

import com.clibchina.shopping.dao.ShopCUserDao;
import com.clibchina.shopping.dao.ShopUserDao;
import com.clibchina.shopping.domain.ShopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CUserService {

    @Autowired
    ShopUserDao shopCUserDao;

    public ShopUser queryShopUserByUserName(String userName) {
        ShopUser shopUser = shopCUserDao.queryShopUserByUserName(userName);
        return shopUser;
    }

    public boolean checkLogin(String userName, String password) {
        ShopUser shopUser = shopCUserDao.queryShopUserByUserName(userName);
        if (shopUser.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean register(ShopUser shopUser) {
        ShopUser temp = shopCUserDao.queryShopUserByUserName(shopUser.getName());
        if (temp == null) {
            shopCUserDao.addShopUser(shopUser);
            return true;
        } else  {
            return false;
        }

    }

    public void changePassword(ShopUser shopUser) {
        shopCUserDao.updateShopUserById(shopUser);
    }
}
