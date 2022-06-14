package d2; /**
 * @ Classname ${NAME}
 * @ Description TODO
 * @ Date 2022/5/29 20:51
 * @ Created by 落尘
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletDemo05", value = "/demo05")
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo05~~~");

        //共享数据
        request.setAttribute("msg","hello");
        //请求转发
        request.getRequestDispatcher("/demo06").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
