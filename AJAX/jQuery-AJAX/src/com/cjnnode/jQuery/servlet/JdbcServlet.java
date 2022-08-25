package com.cjnnode.jQuery.servlet;


import com.cjnnode.jQuery.bean.City;
import com.cjnnode.jQuery.bean.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @program: AJAX
 * @description: 连接数据库，返回省份或者城市集合
 * @author: 陈建南
 * @create: 2022-08-21 15:58
 **/
public class JdbcServlet  {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String url="jdbc:mysql://localhost:3306/cjnnode";
    private String user="root";
    private String password="123456";

    //查询省份
    public List<Province> provinceList(){
        List<Province> provinceList=new ArrayList<>();
        //连接数据库
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,password);
            String sql="select id,name,shenghui,jiancheng from t_province ";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String shenghui=rs.getString("shenghui");
                String jiancheng=rs.getString("jiancheng");
                //封装省份数据
                Province p=new Province(id,name,shenghui,jiancheng);
                //将数据放入集合
                provinceList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //返回一个包含省份数据的集合
        return provinceList;
    }
    public List<City> cityList(int provinceId){//形参作用是将用户点击的省份的id（也就是城市的provinceId）传给数据库查询
        List<City> list=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,password);
            String sql="select id,name from t_city where provinceId=?";
            ps= conn.prepareStatement(sql);
            ps.setInt(1,provinceId);
            rs=ps.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                int id=rs.getInt("id");
                City city=new City();
                city.setName(name);
                city.setId(id);
                list.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}