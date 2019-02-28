package Grambois.dao;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextDAO {

    public String getText(int textID) throws URISyntaxException {



        // The name of the file to open.
        Path fileName = Paths.get(this.getClass().getClassLoader().getResource("Texte/Erreur.txt").toURI());
        String pathInfo = "Texte/Text";

        switch (textID){

            case 0:
                fileName = Paths.get(this.getClass().getClassLoader().getResource("Texte/WelcomeText.txt").toURI());
            break;






        }

        // This will reference one line at a time
        String line = "";
        String text = "";

        try {
            // FileReader reads text files in the default encoding.
            /*FileReader fileReader =
                    new FileReader(String.valueOf(fileName));*/

            InputStreamReader fileReader = new InputStreamReader(new FileInputStream(String.valueOf(fileName)),"UTF-8");



            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                text = text +" "+ line;
            }

            // Always close files.
            bufferedReader.close();

            return text;
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return null;
    }


}

