package d2_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @ Classname demo02
 * @ Description TODO PrepareStatement对象
 * @ Date 2022/5/15 19:26
 * @ Created by 落尘
 */
public class demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("用户名:");
        String username = sc.next();
        System.out.print("密码:");
        String password = sc.next();

        boolean flag = compare(username,password);
        if (flag)
            System.out.println("成功~~");
        else
            System.out.println("失败~~");
    }

    private static boolean compare(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = " select username, password from login where username = ? and password = ?";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1,username);
            stmt.setString(2,password);

            rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.closeSource(rs,stmt,conn);
        }
        return false;
    }

}
