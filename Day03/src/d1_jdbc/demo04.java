package d1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @ Classname demo04
 * @ Description TODO 删除记录
 * @ Date 2022/5/13 17:14
 * @ Created by 落尘
 */
public class demo04 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","123456");

            //
            String sql = """
                        delete from student where id = 5;
                    """;
            //
            stmt = conn.createStatement();

            //
            int i = stmt.executeUpdate(sql);
            System.out.println(i > 0 ? "成功！" : "失败！");  //影响的行数


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
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
