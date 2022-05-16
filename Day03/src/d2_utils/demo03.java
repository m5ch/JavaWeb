package d2_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ Classname demo03
 * @ Description TODO JDBC 控制事务
 * @ Date 2022/5/15 20:23
 * @ Created by 落尘
 */
public class demo03 {
    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        try {

            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);

            String sql1 = "update login set password = ? where id = ?";
            String sql2 = "update login set password = ? where id = ?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1,"lisi");
            stmt1.setInt(2,1);
            stmt2 = conn.prepareStatement(sql2);
            stmt1.setString(1,"zhangsan");
            stmt2.setInt(2,2);

            stmt1.executeUpdate();
            //创建bug
            int i = 3 / 0;
            stmt2.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            conn.rollback();
        }finally {
            JDBCUtils.closeSource(stmt1,conn);
            JDBCUtils.closeSource(stmt2,null);
        }

    }
}
