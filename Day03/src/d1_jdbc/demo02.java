package d1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @ Classname demo02
 * @ Description TODO insert 语句
 * @ Date 2022/5/13 16:38
 * @ Created by 落尘
 */
public class demo02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "123456");
            //定义sql
            String sql = """
                        insert into student(id,name,score,school) values(4,'韦小宝',85,2)
                    """;
            //获取执行sql的对象
            stmt = conn.createStatement();
            //执行sql
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
