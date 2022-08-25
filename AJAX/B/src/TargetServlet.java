import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: AJAX
 * @description: 代理机制实现跨域访问：目标服务程序
 * @author: 陈建南
 * @create: 2022-08-07 12:56
 **/
@WebServlet("/target")
public class TargetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //响应一个json字符串
        response.getWriter().print("{\"username\":\"jackson\"}");
    }
}