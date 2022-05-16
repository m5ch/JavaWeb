package d2_utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ Classname demo01
 * @ Description TODO JDBC工具类
 * @ Date 2022/5/15 13:02
 * @ Created by 落尘
 */
public class demo01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            conn = JDBCUtils.getConnection();
            String sql = """
                        select id,name,score from student
                    """;

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.print(rs.getInt(1));
                System.out.print(rs.getString(2));
                System.out.print(rs.getDouble(3));
                System.out.println();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.closeSource(rs,stmt,conn);
        }
    }
}
