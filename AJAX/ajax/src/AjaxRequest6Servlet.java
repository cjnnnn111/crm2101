import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: AJAX
 * @description: 返回一段xml字符串
 * @author: 陈建南
 * @create: 2022-08-05 15:19
 **/
@WebServlet("/ajaxRequest06")
public class AjaxRequest6Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //如果服务器端响应XML的话，响应的内容类型需要写成text/xml
        response.setContentType("text/xml;charset=utf-8");
        PrintWriter out = response.getWriter();
        /*
            <students>
                <student>
                    <name>张三</name>
                    <age>20</age>
                </student>
                <student>
                    <name>李四</name>
                    <age>40</age>
                </student>
            </students>
         */
        StringBuilder xml=new StringBuilder();
        //追加为一段具有xml格式的字符串
        xml.append("<students>");
        xml.append("<student>");
        xml.append("<name>张三</name>");
        xml.append("<age>20</age>");
        xml.append("</student>");
        xml.append("<student>");
        xml.append("<name>李四</name>");
        xml.append("<age>40</age>");
        xml.append("</student>");
        xml.append("</students>");
        //响应字符串到前端
        out.print(xml);
    }
}