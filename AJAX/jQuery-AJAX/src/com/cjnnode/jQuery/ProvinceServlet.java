package com.cjnnode.jQuery;

import com.alibaba.fastjson.JSON;
import com.cjnnode.jQuery.bean.Province;
import com.cjnnode.jQuery.servlet.JdbcServlet;
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
 * @description: 将省份list集合转为json格式的字符串
 * @author: 陈建南
 * @create: 2022-08-21 16:21
 **/
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        JdbcServlet js=new JdbcServlet();
        List<Province> list=js.provinceList();
        String jsonStr= JSON.toJSONString(list);
        out.print(jsonStr);
    }
}