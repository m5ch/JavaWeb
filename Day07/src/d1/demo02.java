package d1;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @ Classname demo02
 * @ Description TODO Servlet的方法
 * @ Date 2022/5/27 13:04
 * @ Created by 落尘
 */
public class demo02 implements Servlet {

    /**
     * 初始化方法
     * 在Servlet被创建时执行，智慧执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init~~~");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次Servlet被访问时，执行。执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service~~~");
    }

    /**
     * 获取Servlet的一些信息，如版本作者等等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时，执行，执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy~~");
    }
}
