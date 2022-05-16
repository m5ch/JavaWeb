package d3_pool.druid;

import d3_pool.druid.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Classname demo02
 * @ Description TODO
 * @ Date 2022/5/16 16:48
 * @ Created by 落尘
 */
public class demo02 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils.getConnection();

        System.out.println(conn);


        String sql = "select username from login where id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,1);
        ResultSet rs = stmt.executeQuery();

        rs.next();
        String username = rs.getString(1);
        System.out.println(username);

        JDBCUtils.sourceClose(rs,stmt,conn);


    }
}
