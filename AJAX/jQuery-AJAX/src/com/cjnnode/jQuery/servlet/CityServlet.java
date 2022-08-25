package com.cjnnode.jQuery.servlet;

import com.alibaba.fastjson.JSON;
import com.cjnnode.jQuery.bean.City;
import com.cjnnode.jQuery.bean.Province;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @program: AJAX
 * @description: 城市服务程序
 * @author: 陈建南
 * @create: 2022-08-24 15:07
 **/
@WebServlet("/cityServlet")
public class CityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户点击省份所对应的id（也就是城市的provinceId）
        String province= request.getParameter("provinceId");
        int provinceId= Integer.parseInt(province);
        JdbcServlet js=new JdbcServlet();
        //调用方法返回集合
        List<City> list=js.cityList(provinceId);
        //使用阿里巴巴json类将集合转为具有json格式的字符串
        String cityArr= JSON.toJSONString(list);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        //响应给前端
        out.print(cityArr);
    }
}