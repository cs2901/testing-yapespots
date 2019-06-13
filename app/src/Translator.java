import java.util.Dictionary;

public class Translator {
    String wordFile;
    String inputLanguage;
    String outputLanguage;
    Dictionary dictionary;


    public Translator(String wordFile, String inputLanguage, String outputLanguage) {
        this.wordFile = wordFile;
        this.inputLanguage = inputLanguage;
        this.outputLanguage = outputLanguage;
    }

    String getTranslate(String query){
        query = query.toLowerCase();
        String translation = "";
        String queryWords[] =  query.split(" ");
        for (int i = 0; i < queryWords.length; i++) {
            translation += dictionary.get(queryWords[i]);
            if (i != queryWords.length)
                translation += " ";
        }
        return translation;
    }
}
