package d3_pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Classname demo01
 * @ Description TODO
 * @ Date 2022/5/16 14:29
 * @ Created by 落尘
 */
public class demo01 {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();

        //获取连接对象
        Connection conn = ds.getConnection();

        //打印
        System.out.println(conn);
    }
}
