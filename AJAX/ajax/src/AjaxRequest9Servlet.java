import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: AJAX
 * @description: 返回一段json格式的字符串
 * @author: 陈建南
 * @create: 2022-08-05 22:02
 **/
@WebServlet("/ajaxRequest09")
public class AjaxRequest9Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=request.getParameter("username");
        response.getWriter().print("{\"username\":\""+username+"\"}");
    }
}