import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: AJAX
 * @description: jsonp实现跨域访问
 * @author: 陈建南
 * @create: 2022-08-06 19:43
 **/
@WebServlet("/jsonp1")
public class JsonpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //向前端发送一段js代码
        /*
            "alert(123)"：响应一段js代码，只不过这个alert函数是js内置的函数，可以直接用
                    后端java代码响应一段字符串，服务器只负责响应，
                    真正的调用者还是浏览器，浏览器收到这段字符串，会自动将这段字符串当做一段js代码解释并执行
         */
        //response.getWriter().print("alert(123)");
        //同理，我们可以在前端页面自定义一个函数，服务器端响应一段js代码
        //传一个json数据给前端sayHello函数
        //response.getWriter().print("sayHello({\"username\":\"zhangsan\"})");
        //当函数名在src中声明后
        //获取函数名
        String fun=request.getParameter("fun");
        //响应
        response.getWriter().print(fun+"()");
    }
}