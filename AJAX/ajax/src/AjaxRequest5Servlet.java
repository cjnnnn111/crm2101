import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: AJAX
 * @description: json连接数据库进行数据展示
 * @author: 陈建南
 * @create: 2022-08-05 12:06
 **/
@WebServlet("/ajaxRequest05")
public class AjaxRequest5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //list集合存放Student对象
        List<Student> list=new ArrayList();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //连接数据库
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123456");
            String sql="select name,age,address from t_student";
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                int age=rs.getInt("age");
                String address=rs.getString("address");
                //将数据封装到Student对象中
                Student student=new Student(name,age,address);
                //存入Student对象
                list.add(student);
            }
            /**
             * 阿里巴巴的fastjson组件中有一个JSON类：
             *      相关方法可以将Object对象、集合转换为json格式的字符串
             *      JSON类中的方法都是静态方法，直接调用即可
             */
            String jsonStr= JSON.toJSONString(list);
            //响应到前端页面
            out.print(jsonStr);
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
    }
}