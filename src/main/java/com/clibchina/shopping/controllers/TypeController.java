package com.clibchina.shopping.controllers;

import com.alibaba.fastjson.JSONObject;
import com.clibchina.shopping.domain.ShopType;
import com.clibchina.shopping.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TypeController extends PublicController {

    @Autowired
    TypeService typeService;

    @RequestMapping(value = "/addType", method = RequestMethod.GET)
    @ResponseBody
    public void addType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String typeName = request.getParameter("typeName");
        String description = request.getParameter("description");
        String sign = request.getParameter("sign");
        ShopType shopType = new ShopType();
        shopType.setTypeName(typeName);
        shopType.setDescription(description);
        shopType.setSign(Integer.parseInt(sign));
        typeService.addShopType(shopType);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        writeAjax(response, jsonObject);
        return;
    }

    @RequestMapping(value = "/deleteType")
    @ResponseBody
    public ModelAndView deleteType(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        typeService.deleteShopType(id);
        return new ModelAndView("redirect:/classManage");
    }

    @RequestMapping(value = "/editType", method = RequestMethod.GET)
    @ResponseBody
    public void editType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String typeName = request.getParameter("typeName");
        String description = request.getParameter("description");
        String sign = request.getParameter("sign");
        ShopType shopType = new ShopType();
        shopType.setId(Integer.parseInt(id));
        shopType.setTypeName(typeName);
        shopType.setDescription(description);
        shopType.setSign(Integer.parseInt(sign));
        typeService.updateShopType(shopType);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        writeAjax(response, jsonObject);
        return;
    }
}
