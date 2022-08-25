import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: AJAX
 * @description: 测试A应用的ajax请求能访问B应用的程序？
 * @author: 陈建南
 * @create: 2022-08-06 17:24
 **/
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 解决ajax跨域访问解决方案：设置响应头
         *      s:报错内容中的Access-Control-Allow-Origin
         *      s1：对那个ajax请求开发，*代表对全部开放
         */
        response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
        //response.setHeader("Access-Control-Allow-Origin","*");
        response.getWriter().print("hello ajax!!!");
    }
}