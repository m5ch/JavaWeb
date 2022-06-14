package d1;
/**
 * @ Classname ${NAME}
 * @ Description TODO 演示Request对象获取请求行数据
 * @ Date 2022/5/27 19:58
 * @ Created by 落尘
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletDemo01", value = "/demo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            1. 获取请求方式(GET): String getMethod()
            2. **获取虚拟目录**(/Day08): String getContextPath()
            3. 获取Servlet路径(demo01): String getServletPath()
            4. 获取get方式请求参数(name=zhangsan): String getQueryString()
            5. **获取请求URI**(/Day08/demo01):
               * String getRequestURI() : /Day08/demo01
               * StringBuffer getRequestURL(): http://localhost/Day08/demo01
            6. 获取协议及版本(HTTP/1.1): String getProtocol()
            7. 获取客户机的IP地址: String grtRemoteAddr()
         */

        //1. 获取请求方式(GET): String getMethod()
        String method = request.getMethod();
        System.out.println(method);
        System.out.println("==================");

        //2. **获取虚拟目录**(/Day08): String getContextPath()
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        System.out.println("=================");
        //3. 获取Servlet路径(demo01): String getServletPath()
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        System.out.println("===================");
        //4. 获取get方式请求参数(name=zhangsan): String getQueryString()
        String queryString = request.getQueryString();
        System.out.println(queryString);
        System.out.println("=================");
        //5. **获取请求URI**(/Day08/demo01):
        //     * String getRequestURI() : /Day08/demo01
        //     * StringBuffer getRequestURL(): http://localhost/Day08/demo01
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
        System.out.println("==================");
        //6. 获取协议及版本(HTTP/1.1): String getProtocol()
        String protocol = request.getProtocol();
        System.out.println(protocol);
        System.out.println("======================");
        //7. 获取客户机的IP地址: String grtRemoteAddr()
        String addr = request.getRemoteAddr();
        System.out.println(addr);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
