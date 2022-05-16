package d1_jdbc;

import java.sql.*;

/**
 * @ Classname demo06
 * @ Description TODO 单行查询
 * @ Date 2022/5/13 18:28
 * @ Created by 落尘
 */
public class demo06 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet re = null;

        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","123456");
            //定义sql语句
            String sql = """
                        select id,name,score from student
                    """;
            //获取sql执行语句
            stmt = conn.createStatement();
            //执行sql语句
            re = stmt.executeQuery(sql);
            //让游标向下移动一行
            re.next();
            //获取数据
            int id = re.getInt("id");
            String name = re.getString(2);
            double score = re.getDouble("score");

            System.out.println(id + "--" + name + "--" + score);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (re != null) {
                try {
                    re.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
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
