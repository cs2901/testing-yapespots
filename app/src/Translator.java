import java.util.Collection;
import java.util.Dictionary;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Translator {
    String wordFile;
    String inputLanguage;
    String outputLanguage;
    Map<String, String> dictionary = new HashMap<String, String>();


    public Translator(String wordFile, String inputLanguage, String outputLanguage) throws ParserConfigurationException, IOException, SAXException {
        this.wordFile = wordFile;
        this.inputLanguage = inputLanguage;
        this.outputLanguage = outputLanguage;



        // Español Ingles
        if (inputLanguage == "es" && outputLanguage == "en") {
            dictionary.put("perro","dog");
            dictionary.put("puerta","door");
            dictionary.put("pizarra","board");
            dictionary.put("casa","house");
            dictionary.put("ventana","window");
            dictionary.put("la","the");
            dictionary.put("en","in");
            dictionary.put("esta","is");
        }
        if (inputLanguage == "en" && outputLanguage == "es") {
            dictionary.put("dog", "perro");
            dictionary.put("door", "puerta");
            dictionary.put("board", "pizarra");
            dictionary.put("casa","house");
            dictionary.put("window", "ventana");
            dictionary.put("the", "la");
            dictionary.put("in", "en");
            dictionary.put("is", "esta");
        }

        // Español Frances
        if (inputLanguage == "fr" && outputLanguage == "es") {
            dictionary.put("chien","perro");
            dictionary.put("chat","gato");
            dictionary.put("mison","casa");
            dictionary.put("ecran","pantalla");
            dictionary.put("et","esta en");
        }
        if (inputLanguage == "es" && outputLanguage == "fr") {
            dictionary.put("perro", "chien");
            dictionary.put("gato", "chat");
            dictionary.put("casa", "mison");
            dictionary.put("pantalla", "ecran");
            dictionary.put("esta en", "et");
        }

        //Español Portugues
        if (inputLanguage == "es" && outputLanguage == "pr") {
            dictionary.put("perro", "cão");
            dictionary.put("gato", "gato");
            dictionary.put("casa", "lar");
            dictionary.put("pantalla", "tela");
            dictionary.put("esta", "esta");
            dictionary.put("en", "em");
        }
        if (inputLanguage == "pr" && outputLanguage == "es") {
            dictionary.put("cão", "perro");
            dictionary.put("gato", "gato");
            dictionary.put("lar", "casa");
            dictionary.put("tela", "pantalla");
            dictionary.put("esta", "esta");
            dictionary.put("em", "en");
        }

        // Frances Ingles
        if (inputLanguage == "fr" && outputLanguage == "en") {
            dictionary.put("chien","dog");
            dictionary.put("porte","door");
            dictionary.put("planche","board");
            dictionary.put("maison","house");
            dictionary.put("fenêtre","window");
            dictionary.put("la","the");
            dictionary.put("dans","in");
            dictionary.put("est","is");
        }
        if (inputLanguage == "en" && outputLanguage == "fr") {
            dictionary.put("dog", "chien");
            dictionary.put("door", "porte");
            dictionary.put("board", "planche");
            dictionary.put("house","maison");
            dictionary.put("window", "la fenêtre");
            dictionary.put("the", "la");
            dictionary.put("in", "dans");
            dictionary.put("is", "est");
        }

        //Frances Portugues
        if (inputLanguage == "fr" && outputLanguage == "pr") {
            dictionary.put("chien","cão");
            dictionary.put("porte","porta");
            dictionary.put("planche","borda");
            dictionary.put("maison","casa");
            dictionary.put("fenêtre","janela");
            dictionary.put("la","a");
            dictionary.put("dans","em");
            dictionary.put("est","é");
        }
        if (inputLanguage == "pr" && outputLanguage == "fr") {
            dictionary.put("cão", "chien");
            dictionary.put("porta", "porte");
            dictionary.put("borda", "planche");
            dictionary.put("casa","maison");
            dictionary.put("janela", "la fenêtre");
            dictionary.put("aes", "la");
            dictionary.put("em", "dans");
            dictionary.put("é", "est");
        }

        //Ingles portugues
        if (inputLanguage == "pr" && outputLanguage == "en") {
            dictionary.put("cão","dog");
            dictionary.put("porta","door");
            dictionary.put("borda","board");
            dictionary.put("casa","house");
            dictionary.put("janela","window");
            dictionary.put("aes","the");
            dictionary.put("em","in");
            dictionary.put("é","is");
        }
        if (inputLanguage == "en" && outputLanguage == "pr") {
            dictionary.put("dog", "cão");
            dictionary.put("door", "porta");
            dictionary.put("board", "borda");
            dictionary.put("house","casa");
            dictionary.put("window", "janela");
            dictionary.put("the", "aes");
            dictionary.put("in", "em");
            dictionary.put("is", "é");
        }

//        try {
//            File inputFile = new File(wordFile);
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(inputFile);
//            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//            NodeList nList = doc.getElementsByTagName("w");
//            System.out.println("----------------------------");
//
//            for (int temp = 0; temp < nList.getLength(); temp++) {
//                Node nNode = nList.item(temp);
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element eElement = (Element) nNode;
//                    dictionary.put(eElement.getAttribute("c"),eElement.getAttribute("d"));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



    }

    String getTranslate(String query){
        query = query.toLowerCase();
        //query = query.replaceAll("[^a-zA-Z0-9]", "");
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
        Translator translator = new Translator("resources/es-en.xml", "es", "en");
        System.out.println(translator.getTranslate("Juan's Perro esta en la puerta"));
        System.out.println(translator.getTranslate("chien et ecran"));
        System.out.println(translator.getTranslate("puerta"));
    }
}