package d3_pool.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @ Classname demo01
 * @ Description TODO
 * @ Date 2022/5/16 15:11
 * @ Created by 落尘
 */
public class demo01 {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties ps = new Properties();
        InputStream is = demo01.class.getClassLoader().getResourceAsStream("druid.properties");
        ps.load(is);

        //索取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(ps);

        //
        Connection conn = ds.getConnection();

        System.out.println(conn);
    }

}
