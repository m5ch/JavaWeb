package d2_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @ Classname demo03
 * @ Description TODO
 * @ Date 2022/5/24 21:17
 * @ Created by 落尘
 */
public class demo03 {
    public static void main(String[] args) throws IOException {
        //
        String path = demo03.class.getClassLoader().getResource("d2_jsoup/students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        //获取元素对象
        Elements student = document.getElementsByTag("student");
        for (Element element : student) {
            System.out.println(element);
        }
        System.out.println("========================");

        Elements id = document.getElementsByAttribute("id");
        for (Element element : id) {
            System.out.println(element);
        }

        System.out.println("=========================");
        Elements value = document.getElementsByAttributeValue("number", "s1");
        for (Element element : value) {
            System.out.println(element);
        }

        System.out.println("================");
        Element s1 = document.getElementById("1");
        System.out.println(s1);


    }
}