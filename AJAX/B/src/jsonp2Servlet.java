import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: AJAX
 * @description: jsonp解决跨域问题深入
 * @author: 陈建南
 * @create: 2022-08-06 20:44
 **/
@WebServlet("/jsonp2")
public class jsonp2Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取函数名
        String fun=request.getParameter("fun");
        //响应一段js代码
        response.getWriter().print(fun+"({\"username\":\"张三\"})");
    }
}