import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;

/**
 * @program: AJAX
 * @description: 测试自己写的jQuery，返回一段json格式字符串
 * @author: 陈建南
 * @create: 2022-08-06 00:09
 **/
@WebServlet("/ajaxRequest10")
public class AjaxRequest10Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=request.getParameter("username");
        //json：{"username":"+username+"}
        response.getWriter().print("{\"username\":\""+username.toUpperCase()+"\"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=request.getParameter("username");
        //json：{"username":"+username+"}
        response.getWriter().print("{\"username\":\""+username.toLowerCase()+"\"}");
    }
}