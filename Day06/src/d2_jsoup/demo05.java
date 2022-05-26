package d2_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @ Classname demo05
 * @ Description TODO 选择器查询
 * @ Date 2022/5/25 16:47
 * @ Created by 落尘
 */
public class demo05 {
    public static void main(String[] args) throws Exception {
        String path = demo05.class.getClassLoader().getResource("d2_jsoup/students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        /*
            select选择器
         */
        // 查询标签为name的元素
        Elements name = document.select("name");
        for (Element element : name) {
            System.out.println(element);
        }
        System.out.println("++++++++++++++++++++++");
        //查询id为1的元素
        Elements id = document.select("#1");
        System.out.println(id);
        System.out.println("==============");
        //查询student下的number为s1的元素
        Elements s1 = document.select("student[number='s1']");
        System.out.println(s1);


    }
}
