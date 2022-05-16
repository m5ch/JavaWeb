package d2_utils.task;

import d2_utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ Classname main
 * @ Description TODO
 * @ Date 2022/5/15 14:28
 * @ Created by 落尘
 */
public class main {
    public static void main(String[] args) {
        List<User> users = getUser();
        for (User user : users) {
            System.out.println(user);
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("用户名:");
        String username = sc.next();
        System.out.print("密码:");
        String password = sc.next();

        boolean flag = compare(users, username,password);
        if (flag)
            System.out.println("成功~~");
        else
            System.out.println("失败~~");

    }

    private static boolean compare(List<User> users, String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                if (user.getPassword().equals(password))
                    return true;
        }
        return false;
    }

    public static List<User> getUser(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();

            stmt = conn.createStatement();

            String sql = """
                        select id, username, password from login
                    """;
            rs = stmt.executeQuery(sql);


            User user = null;
            while(rs.next()){
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password =  rs.getString(3);

                user = new User();
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);

                users.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeSource(rs,stmt,conn);
        }
        return users;
    }


}
