package d1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @ Classname demo01
 * @ Description TODO JDBC快速入门
 * @ Date 2022/5/13 14:18
 * @ Created by 落尘
 */
public class demo01 {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");

        //定义sql语句
        String sql = """
                    update student set sname = '刘备' where sid = 1
                """;
        //获取执行sql对象 Statement
        Statement statement = conn.createStatement();

        //执行sql
        int i = statement.executeUpdate(sql);

        System.out.println(i);

        //释放资源
        statement.close();
        conn.close();
    }
}
