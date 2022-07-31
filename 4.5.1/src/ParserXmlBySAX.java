import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserXmlBySAX extends DefaultHandler {
    // 记录档期那解析到的节点名
    private String tagName;

    public static void main(String[] args) {
        String uri = "4.5.1/book.xml";
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            ParserXmlBySAX myParser = new ParserXmlBySAX();
            SAXParser parser = parserFactory.newSAXParser();
            parser.parse(uri, myParser);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }


    // 开始处理文档时，直接输出，不做任何动作
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("startDocument");
    }

    // 处理到文档的结尾
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("endDocument");
    }

    // 开始处理标签
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("book".equals(qName)) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("attribute name is : " + attributes.getLocalName(i) + " attribute value : " + attributes.getValue(i));
            }
        }
        // 把当前标签的名称记录到tagName
        tagName = qName;
    }

    // 处理到结束标签时，把记录当前标签名成功tagName设置成null
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        tagName = null;
    }

    // 通过此方法解析book的三个字元素的值
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (this.tagName != null) {
            String val = new String(ch, start, length);
            if ("name".equals(tagName)) {
                System.out.println("name is : " + val);
            }
            if ("price".equals(tagName)) {
                System.out.println("price is : " + val);
            }
            if ("memo".equals(tagName)) {
                System.out.println("memo is : " + val);
            }
        }
    }
}
