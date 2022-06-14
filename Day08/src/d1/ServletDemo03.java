package d1; /**
 * @ Classname ${NAME}
 * @ Description TODO
 * @ Date 2022/5/29 14:29
 * @ Created by 落尘
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "ServletDemo03", value = "/demo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            获取请求消息体--请求参数
         */

        //1. 获取字符流
        BufferedReader reader = request.getReader();
        //2. 读取数据
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }
}
