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
 * @description: ajax实现自动补全和自动联想
 * @author: 陈建南
 * @create: 2022-08-07 14:45
 **/
@WebServlet("/completion")
public class AutoCompletionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String value=request.getParameter("data");
        //连接数据库
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Data> list=new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/cjnnode";
            String user="root";
            String password="123456";
            conn= DriverManager.getConnection(url,user,password);
            String sql="select data from t_data where data like ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,value+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                String data=rs.getString("data");
                Data d=new Data(data);
                list.add(d);
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
        String jsonStr = JSON.toJSONString(list);
        response.getWriter().print(jsonStr);
    }
}