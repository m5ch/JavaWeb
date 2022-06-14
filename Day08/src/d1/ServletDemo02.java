package d1; /**
 * @ Classname ${NAME}
 * @ Description TODO 获取请求头的数据
 * @ Date 2022/5/29 14:00
 * @ Created by 落尘
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletDemo02", value = "/demo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            获取请求头数据
         */
        //1. 获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //2. 遍历
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            System.out.println(name + "----" + header);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
