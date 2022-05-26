package d2_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @ Classname demo04
 * @ Description TODO Element对象
 * @ Date 2022/5/25 10:38
 * @ Created by 落尘
 */
public class demo04 {
    public static void main(String[] args) throws IOException {
        //
        String path = demo04.class.getClassLoader().getResource("d2_jsoup/students.xml").getPath();
        //
        Document document = Jsoup.parse(new File(path), "utf-8");

        //
        Elements students = document.getElementsByTag("student");
        System.out.println(students.size());
        System.out.println("======================");
        //
        Element student = document.getElementsByTag("student").get(0);
        System.out.println(student);
        //获取属性值
        System.out.println("====================");
        String number = student.attr("number");
        System.out.println(number);

        //获取文本内容
        String text = student.text();
        System.out.println(text);
        System.out.println("=================");
        String html = student.html();
        System.out.println(html);


    }
}
