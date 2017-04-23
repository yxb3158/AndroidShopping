package com.clibchina.shopping.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.clibchina.shopping.anno.TableParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

public class PublicController {


    public void writeAjax(HttpServletResponse response, JSONObject jsonObject) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        OutputStream ps = response.getOutputStream();
        ps.write(jsonObject.toJSONString().getBytes("UTF-8"));
    }

    public void writeAjax(HttpServletResponse response, JSONArray jsonArray) throws IOException {
        System.out.println(jsonArray.toJSONString());
        response.getWriter().write(jsonArray.toJSONString());
    }

    public void writeAjax(HttpServletResponse response, List<?> resultList) throws IOException, IllegalAccessException {
        JSONArray jsonArray = new JSONArray();

        for(Object obj : resultList) {
            Class clazz = obj.getClass();
            JSONObject jsonObject = new JSONObject();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                TableParam tableParam = field.getAnnotation(TableParam.class);
                if(tableParam != null) {
                    jsonObject.put(tableParam.value(), (String)field.get(obj));
                }else {
                }
            }

            jsonArray.add(jsonObject);
        }
        response.getWriter().write(jsonArray.toJSONString());
    }

    public void writeString(HttpServletResponse response, String s) throws IOException {
        response.getWriter().write(s);
    }
}
