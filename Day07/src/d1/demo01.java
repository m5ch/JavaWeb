package d1;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @ Classname demo01
 * @ Description TODO Servlet快速入门
 * @ Date 2022/5/26 20:38
 * @ Created by 落尘
 */
public class demo01 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("你好啊~~~");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
