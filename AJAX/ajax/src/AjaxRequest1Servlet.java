import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajax01")
public class AjaxRequest1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        //out对象向浏览器输出信息，服务器的代码和以前的代码一样
        //只不过这个out响应的时候，浏览器客户端的XMLHttpRequest对象会接收到这个响应信息
        out.print("<font color='red'>welcome to study ajax</font>");
    }
}
