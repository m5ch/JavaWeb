package d2_utils.task;

import d2_utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @ Classname main01
 * @ Description TODO 老师的方法
 * @ Date 2022/5/15 15:11
 * @ Created by 落尘
 */
public class main01 {
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
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();

            String sql = " select username, password from login where username = '"+username+"' and password = '"+password+"'";

            rs = stmt.executeQuery(sql);

            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.closeSource(rs,stmt,conn);
        }
        return false;
    }


}
