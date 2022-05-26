package d2_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * @ Classname demo02
 * @ Description TODO Jsoup对象功能
 * @ Date 2022/5/24 21:00
 * @ Created by 落尘
 */
public class demo02 {
    public static void main(String[] args) throws IOException {
        //
        String path = demo02.class.getClassLoader().getResource("d2_jsoup/students.xml").getPath();

        //1 parse(File in,，String charsetName)解析xml或html文件的。
//        Document document = Jsoup.parse(new File(path), "utf-8");
//        System.out.println(document);
        //2 parse(String html)∶解析xml或html字符串
//        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
//                "\n" +
//                "<students>\n" +
//                "\n" +
//                "    <student nember=\"s1\">\n" +
//                "        <name>张三</name>\n" +
//                "        <age>21</age>\n" +
//                "        <sex>男</sex>\n" +
//                "    </student>\n" +
//                "    <student nember=\"s1\">\n" +
//                "        <name>李四</name>\n" +
//                "        <age>30</age>\n" +
//                "        <sex>男</sex>\n" +
//                "    </student>\n" +
//                "</students>";
//        Document document = Jsoup.parse(str);
//        System.out.println(document);

        //3 parse(URL url, int timeoutMillis):通过网络路径获取指定的html或xml的文档对象
        URL url = new URL("https://www.bilibili.com/");
        Document document = Jsoup.parse(url,10000);
        System.out.println(document);

    }
}
