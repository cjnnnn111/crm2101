import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * 用户名验证
 */
@WebServlet("/ajaxRequest4")
public class AjaxRequest4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取用户输入信息
        String username = request.getParameter("username");
        //连接数据库
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //标记，false表示用户名不存在，true表示用户名重复
        boolean flag=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/cjnnode","root","123456");
            String sql="select id,username from t_user2 where username=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            rs= ps.executeQuery();
            if (rs.next()){
                //如果数据库中有，用户名重复，flag=true
                flag=true;
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
        if(flag){
            //用户名重复，红色字体显示
            out.print("<font color='red'>用户名已存在</font>");
        }else{
            //用户名不存在，绿色字体显示
            out.print("<font color='green'>用户名可以使用</font>");
        }
    }
}
