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
            Document document = builder.parse("src\\sample\\communicationStorage\\communication.xml");
            comlist = document.getElementsByTagName("communication");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < comlist.getLength(); i++) {
            Node node = (Node) comlist.item(i);
            NodeList nl = node.getChildNodes();
            for (int j = 0; j < nl.getLength(); j++) {
                Node n = nl.item(j);
                if (n.getNodeType() == Node.ELEMENT_NODE){
                    if (n.getNodeName().equals("id"))
                        System.out.println("id: "+n.getFirstChild().getNodeValue());
                    else if (n.getNodeName().equals("first"))
                        System.out.println("first: "+n.getFirstChild().getNodeValue());
                    else if (n.getNodeName().equals("sentence"))
                        System.out.println("sentence: "+n.getFirstChild().getNodeValue());
                }
            }
            String sentences= comlist.item(i).getNodeName();
            System.out.println(sentences);
        }
    }
}
