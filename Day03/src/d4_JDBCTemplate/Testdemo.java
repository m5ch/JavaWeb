package d4_JDBCTemplate;

import d3_pool.druid.utils.JDBCUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @ Classname Test
 * @ Description TODO
 * @ Date 2022/5/16 19:31
 * @ Created by 落尘
 */
public class Testdemo {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
    @Before
    public void before(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
        System.out.println(template);
    }
    /**
     * 更改数据
     */
    @Test
    public void test1(){
        String sql = "update student set score = ? where id = ?";
        int i = template.update(sql, 99.9, 3);
        System.out.println(i);
    }

    /**
     *  添加数据
     */
    @Test
    public void test2(){
        String sql = "insert into student(id,name,score,school) values(?,?,?,?)";
        template.update(sql,5,"张飞",60,3);
    }

    /**
     * 删除数据
     */
    @Test
    public void test3(){
        String sql = "delete from student where id = ?";
        int i = template.update(sql, 5);
        System.out.println(i);
    }

    /**
     *  查询并封装为Map对象
     */
    @Test
    public void rest4(){
        String sql = "select * from student where id = 1";
        Map<String, Object> map = template.queryForMap(sql);
        System.out.println(map);
    }

    /**
     * 查询并封装为List集合
     */
    @Test
    public void test5(){
        String sql = "select * from login";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> li : list) {
            System.out.println(li);
        }
    }

    /**
     * 查询并封装为JavaBean对象
     */
    @Test
    public void test6(){
        String sql = "select * from login";
        List<User> lists = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        for (User list : lists) {
            System.out.println(list);
        }
    }

    /**
     *  查询总数记录
     */
    @Test
    public void test7(){
        String sql = "select count(id) from student";
        Long l = template.queryForObject(sql, Long.class);
        System.out.println(l);

    }

}
