package com.clibchina.shopping.controllers.android;

import com.alibaba.fastjson.JSONObject;
import com.clibchina.shopping.controllers.PublicController;
import com.clibchina.shopping.domain.ShopCart;
import com.clibchina.shopping.domain.ShopUser;
import com.clibchina.shopping.service.CUserService;
import com.clibchina.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping(value = "/android")
public class AndroidCartController extends PublicController {

    @Autowired
    CartService cartService;

    @RequestMapping(value = "/addCart", method = RequestMethod.GET)
    @ResponseBody
    public void addCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String userId = request.getParameter("userId");
        String goodsId = request.getParameter("goodsId");

        ShopCart shopCart = cartService.getShopCartByUserIdAndGoodsId(Integer.parseInt(userId), Integer.parseInt(goodsId));
        if (shopCart == null) {
            shopCart = new ShopCart();
            shopCart.setUserId(Integer.parseInt(userId));
            shopCart.setGoodsId(Integer.parseInt(goodsId));
            shopCart.setNum(1);
            cartService.addShopCart(shopCart);
        } else {
            shopCart.setNum(shopCart.getNum() + 1);
            cartService.updateShopCart(shopCart);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        writeAjax(response, jsonObject);
        return;
    }

    @RequestMapping(value = "/reduceCart", method = RequestMethod.GET)
    @ResponseBody
    public void reduceCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String userId = request.getParameter("userId");
        String goodsId = request.getParameter("goodsId");

        ShopCart shopCart = cartService.getShopCartByUserIdAndGoodsId(Integer.parseInt(userId), Integer.parseInt(goodsId));
        if (shopCart.getNum() > 1) {
            shopCart.setNum(shopCart.getNum() - 1);
            cartService.updateShopCart(shopCart);
        } else {
            cartService.deleteShopCart(shopCart.getUserId(), shopCart.getGoodsId());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        writeAjax(response, jsonObject);
        return;
    }


    @RequestMapping(value = "/clearCart", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView clearCart(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String userId = request.getParameter("userId");
        cartService.deleteShopCartByUserId(Integer.parseInt(userId));
        return new ModelAndView("redirect:/android/shopping?userName=" + userName + "&userId=" + userId);
    }

}
