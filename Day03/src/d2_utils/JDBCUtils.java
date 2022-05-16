package d2_utils;

import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @ Classname JDBCutils
 * @ Description TODO
 * @ Date 2022/5/15 13:08
 * @ Created by 落尘
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /*
        文件的读取，只需要读取一次就可以拿到这些值
     */
    static{
        try {
            Properties pro = new Properties();
            //获取src路径下的文件方式 --> ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL urls = classLoader.getResource("d2_utils/jdbc.properties");
            String path = urls.getPath();
            pro.load(new FileReader(path));

//            pro.load(new FileReader("Day03/src/d2_utils/jdbc.properties"));

            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接对象
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void closeSource(Statement stmt, Connection conn){
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
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

    public static void closeSource(ResultSet rs, Statement stmt, Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
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
