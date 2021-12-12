package sample.specificPlace;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Dialogue {
    String id;
    int first;
    String[] sentence = new String[10];
    int size = 0;
    String button;

    public Dialogue(String id){
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        NodeList communicationList = null;
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse("src\\sample\\specificPlace\\communication.xml");
            communicationList = document.getElementsByTagName("communication");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < communicationList.getLength(); i++) {
            Node communication = (Node) communicationList.item(i);
            NodeList contentList = communication.getChildNodes();
            Boolean find = false;
            for (int j = 0; j < contentList.getLength(); j++) {
                Node content = contentList.item(j);
                if (content.getNodeType() == Node.ELEMENT_NODE){
                    if (content.getNodeName().equals("id") && content.getFirstChild().getNodeValue().equals(id)){
                        find = true;
                    }
                    else if (content.getNodeName().equals("id")){
                        find = false;
                    }
                    else if (content.getNodeName().equals("button") && find){
                        button = content.getFirstChild().getNodeValue();
                    }
                    else if (content.getNodeName().equals("first") && find){
                        first = Integer.parseInt(content.getFirstChild().getNodeValue());
                    }
                    else if (content.getNodeName().equals("sentence") && find){
                        add(content.getFirstChild().getNodeValue());
                    }
                }
            }
        }
    }

    public void add(String s){
        if (sentence.length <= getSize()){
            extendSize();
        }
        sentence[size] = s;
        size++;
    }

    public void extendSize(){
        String[] tem = new String[getSize()*2];
        for (int i = 0; i < getSize(); i++) {
            tem[i] = sentence[i];
        }
        sentence = tem;
    }

    public int getSize() {
        return size;
    }

    public int getFirst() {
        return first;
    }

    public String[] getSentence() {
        String[] out = new String[getSize()];
        for (int i = 0; i < getSize(); i++) {
            out[i] = sentence[i];
        }
        return out;
    }

    public String getId() {
        return id;
    }

    public String getButton() {
        return button;
    }
}
