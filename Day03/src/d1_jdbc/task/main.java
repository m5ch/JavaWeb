package d1_jdbc.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Classname main
 * @ Description TODO 定义一个方法，查询 movie250 表的数据将其封装为对象，然后装载集合，返回。
 * @ Date 2022/5/13 18:51
 * @ Created by 落尘
 */
public class main {
    public static void main(String[] args) {
        List<Movie> lists = select();
        for (Movie list : lists) {
            System.out.println(list);
        }
    }

    public static List<Movie> select(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Movie> movies = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
            //定义sql
            String sql = """
                        select * from movie250;
                    """;
            //获取执行对象
            stmt = conn.createStatement();
            //
            rs = stmt.executeQuery(sql);

            //创建Movie对象
            Movie movie = null;
            //创建集合
            movies = new ArrayList<>();

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String link = rs.getString(3);
                double score = rs.getDouble(4);
                int rate = rs.getInt(5);
                String su = rs.getNString(6);

                movie = new Movie();

                movie.setId(id);
                movie.setName(name);
                movie.setLink(link);
                movie.setScore(score);
                movie.setRate(rate);
                movie.setSu(su);

                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
}
