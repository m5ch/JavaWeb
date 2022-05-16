package d1_jdbc;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ Classname demo03
 * @ Description TODO 修改记录
 * @ Date 2022/5/13 17:01
 * @ Created by 落尘
 */
public class demo03 {
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
                        update student set school = 1 where id = 4;
                    """;
            //获取sql执行语句
            stmt = conn.createStatement();
            //执行sql语句
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
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
