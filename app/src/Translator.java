import java.util.Dictionary;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class Translator {
    String wordFile;
    String inputLanguage;
    String outputLanguage;
    Dictionary dictionary;


    public Translator(String wordFile, String inputLanguage, String outputLanguage) throws ParserConfigurationException, IOException, SAXException {
        this.wordFile = wordFile;
        this.inputLanguage = inputLanguage;
        this.outputLanguage = outputLanguage;

        try {
            File inputFile = new File(wordFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("w");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    dictionary.put(eElement.getAttribute("c"),eElement.getAttribute("d"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    String getTranslate(String query){
        query = query.toLowerCase();
        query = query.replaceAll("[^a-zA-Z0-9]", "");
        String translation = "";
        String queryWords[] =  query.split(" ");
        for (int i = 0; i < queryWords.length; i++) {
            if (dictionary.get(queryWords[i]) != null)
                translation += dictionary.get(queryWords[i]);
            else
                translation += queryWords[i];
            if (i != queryWords.length)
                translation += " ";
        }
        return translation;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Translator translator = new Translator("resources/es-en.xml", "Spanish", "Enaglish");
        translator.getTranslate("Perro");
    }
}