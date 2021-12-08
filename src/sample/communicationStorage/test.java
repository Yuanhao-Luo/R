package sample.communicationStorage;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        NodeList comlist = null;
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse("commutest.xml");
            comlist = document.getElementsByTagName("com");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < comlist.getLength(); i++) {
            System.out.println(comlist.item(i).getFirstChild().getNodeValue());
        }
    }
}
