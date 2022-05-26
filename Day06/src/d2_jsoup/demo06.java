package d2_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ Classname demo06
 * @ Description TODO jsoupXpath的简单入门
 * @ Date 2022/5/26 13:03
 * @ Created by 落尘
 */
public class demo06 {
    public static void main(String[] args) throws IOException {
        //
        String path = demo06.class.getClassLoader().getResource("d2_jsoup/students.xml").getPath();

        Document document = Jsoup.parse(new File(path), "utf-8");

        JXDocument jxDocument = JXDocument.create(document);

        List<JXNode> jxNodes = jxDocument.selN("//student");

        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }


    }
}
