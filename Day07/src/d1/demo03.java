package d1;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/**
 * @ Classname demo03
 * @ Description TODO GenericServlet
 * @ Date 2022/5/27 14:51
 * @ Created by 落尘
 */

@WebServlet("/demo03")
public class demo03 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo03");
    }
}
