package d1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ Classname demo05
 * @ Description TODO DDL语句
 * @ Date 2022/5/13 17:23
 * @ Created by 落尘
 */
public class demo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","123456");
            //定义sql语句
            String sql = """
                        create table teacher(
                            id int,
                            name varchar(20),
                            workAge int
                        )
                    """;
            //获取sql执行语句
            stmt = conn.createStatement();
            //执行sql语句
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
