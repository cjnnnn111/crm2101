import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @program: AJAX
 * @description: 代理机制实现跨域访问：代理的服务程序（中转）
 *               这种方式需要使用到第三方的开源组件：httpclient（使用httpclient组件，需要先将这个组件相关的jar包引入到项目当中）
 * @author: 陈建南
 * @create: 2022-08-07 12:52
 **/
@WebServlet("/proxy")
public class ProxyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String charset = "UTF-8";
            //创建CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.custom().build();
            String url = "http://localhost:8081/B/target";
            //如果有带参数,直接在url后面加?号拼接 例如 http://www.baidu.com?a=n&b=n
            //请求方式
            HttpGet get = new HttpGet(url);
            //接收请求返回对象
            HttpEntity entity =httpClient.execute(get).getEntity();
            //使用EntityUtils 把httpEntity请求返回流读取成字符串
            String result = EntityUtils.toString(entity,charset);
            response.getWriter().print(result);
            EntityUtils.consume(entity);
            httpClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}