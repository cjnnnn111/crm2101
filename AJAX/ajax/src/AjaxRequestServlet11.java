import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: AJAX
 * @description: 省市联动服务程序，返回json格式字符串
 * @author: 陈建南
 * @create: 2022-08-06 14:35
 **/
@WebServlet("/ajaxRequest11")
public class AjaxRequestServlet11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取pcode
        String pcode=request.getParameter("pcode");
        //连接数据库
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Area> list=new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/cjnnode";
            String user="root";
            String password="123456";
            conn= DriverManager.getConnection(url,user,password);
            String sql="";
            //当pcode=null时，表示全部是省份
            if (pcode==null) {
                //mysql中null不是一个值，不能使用=号来判断
                sql="select code,name from t_area where pcode is null";
                ps=conn.prepareStatement(sql);
            }
            ////pcode为用户点击的省份的code，也是下辖市所对应的pcode
            if(pcode != null) {
                sql = "select code,name from t_area where pcode=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, pcode);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String code = rs.getString("code");
                Area area = new Area(code, name);
                list.add(area);
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
        //使用阿里巴巴的JSON类库，将list集合转为具有json格式的字符串
        String jsonStr= JSON.toJSONString(list);
        //响应到前端页面
        response.getWriter().print(jsonStr);
    }
}