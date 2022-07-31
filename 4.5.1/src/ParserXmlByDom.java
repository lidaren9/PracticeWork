import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ParserXmlByDom {
    public static void main(String[] args) {
        // 创建DOM工厂
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        InputStream input = null;
        try {
            // 通过DOM工厂活得DOM解析器
            DocumentBuilder domBuilder = documentFactory.newDocumentBuilder();
            // 把XML转化成输入流
            input = new FileInputStream("4.5.1/book.xml");
            // 解析XML文档的输入流
            Document document = domBuilder.parse(input);
            // 得到XML文档的根节点，只有根节点才是Element类型
            Element root = document.getDocumentElement();
            // 得到子节点
            NodeList books = root.getChildNodes();
            if (books != null) {
                for (int i = 0; i < books.getLength(); i++) {
                    Node book = books.item(i);
                    if (book.getNodeType() == Node.ELEMENT_NODE) {
                        String id = book.getAttributes().getNamedItem("id").getNodeValue();
                        System.out.println("ID is : " + id);
                        // 便利book下的子节点
                        for (Node node = book.getFirstChild(); node != null; node = node.getNextSibling()) {
                            if (node.getNodeType() == Node.ELEMENT_NODE) {
                                // 依次读取book里的name，price和demo三个子元素
                                if (node.getNodeName().equals("name")) {
                                    String name = node.getFirstChild().getNodeValue();
                                    System.out.println("name is : " + name);
                                }
                                if (node.getNodeName().equals("price")) {
                                    String price = node.getFirstChild().getNodeValue();
                                    System.out.println("price is : " + price);
                                }
                                if (node.getNodeName().equals("memo")) {
                                    String memo = node.getFirstChild().getNodeValue();
                                    System.out.println("memo is : " + memo);
                                }
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
