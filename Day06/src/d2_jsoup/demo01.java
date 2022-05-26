package d2_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @ Classname demo01
 * @ Description TODO Jsoup的快速入门
 * @ Date 2022/5/24 20:06
 * @ Created by 落尘
 */
public class demo01 {
    public static void main(String[] args) throws IOException {
        /*
            获取Document对象
         */
        //1. 根据xml文档对象获取
        //1.1 获取student.xml的path
        String path = demo01.class.getClassLoader().getResource("d2_jsoup/students.xml").getPath();
        System.out.println(path);
        //1.2 解析xml文档，加载文档进入内存，获取odm树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //1.3 获取元素对象 Element
        Elements elements = document.getElementsByTag("name");
        //System.out.println(elements.size());
        // 获取数据
        for (Element element : elements) {
            String name = element.text();
            System.out.println(name);
        }
        Element element = elements.get(0);

    }
}
