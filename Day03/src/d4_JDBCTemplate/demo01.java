package d4_JDBCTemplate;

import d3_pool.druid.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @ Classname demo01
 * @ Description TODO
 * @ Date 2022/5/16 18:41
 * @ Created by 落尘
 */
public class demo01 {
    public static void main(String[] args) throws Exception {
        //创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());

        String sql = "update login set password = ? where username = ?";
//        Connection conn = JDBCUtils.getConnection();
//        PreparedStatement stmt = conn.prepareStatement(sql);
//
//        stmt.setInt(1,1);
//
//        ResultSet rs = stmt.executeQuery();
//        rs.next();
//        String username = rs.getString("username");
//        String password = rs.getString("password");
//
//        System.out.println(username);
//        System.out.println(password);

        //调用方法
        int i = template.update(sql, "123456", "zhangsan");
        System.out.println(i);


    }
}
