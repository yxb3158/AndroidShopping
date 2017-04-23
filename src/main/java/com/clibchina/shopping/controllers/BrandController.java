package com.clibchina.shopping.controllers;

import com.alibaba.fastjson.JSONObject;
import com.clibchina.shopping.domain.ShopBrand;
import com.clibchina.shopping.domain.ShopType;
import com.clibchina.shopping.service.BrandService;
import com.clibchina.shopping.service.TypeService;
import com.clibchina.shopping.tools.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BrandController extends PublicController {

    @Autowired
    BrandService brandService;

    @RequestMapping(value = "/addBrand", method = RequestMethod.GET)
    @ResponseBody
    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        ShopBrand shopBrand = new ShopBrand();
        shopBrand.setName(name);
        shopBrand.setDescription(description);
        shopBrand.setCtime(TimeUtil.getNow());
        brandService.addShopBrand(shopBrand);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        writeAjax(response, jsonObject);
        return;
    }

    @RequestMapping(value = "/deleteBrand")
    @ResponseBody
    public ModelAndView deleteBrand(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        brandService.deleteShopBrand(id);
        return new ModelAndView("redirect:/brandManage");
    }

    @RequestMapping(value = "/editBrand", method = RequestMethod.GET)
    @ResponseBody
    public void editBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        ShopBrand shopBrand = new ShopBrand();
        shopBrand.setId(Integer.parseInt(id));
        shopBrand.setName(name);
        shopBrand.setDescription(description);
        brandService.updateShopBrand(shopBrand);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        writeAjax(response, jsonObject);
        return;
    }
}
