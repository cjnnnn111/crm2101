import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * AJAX发送post请求，并提交数据
 */
@WebServlet("/ajaxRequest03")
public class AjaxRequest3Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取用户输入的数据
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //out.print("<font color='red'>post 请求</font>");
        //在浏览器上响应输出
        out.print("username="+username+","+"password="+password);
    }
}
