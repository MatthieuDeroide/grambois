package Grambois.dao;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class TextDAO {

    /**
    public String getText(int textID) throws URISyntaxException {



// The name of the file to open.
        Path fileName;
        String pathInfo = "Texte/Text";

        if(textID == 0) {
            fileName = Paths.get(this.getClass().getClassLoader().getResource("Texte/WelcomeText.txt").toURI());
        }else{
            fileName = Paths.get(this.getClass().getClassLoader().getResource(pathInfo+textID+".txt").toURI());
        }

        // This will reference one line at a time
        String line = "";
        String text = "";

        try {
            // FileReader reads text files in the default encoding.
            /*FileReader fileReader =
                    new FileReader(String.valueOf(fileName));

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
    }*/

    public String getText(int textID){
        String sqlQuery = "SELECT * FROM Texts WHERE Textid=?;";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setInt(1, textID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return  resultSet.getString("Text");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
    public void changeText(Integer textID, String text) throws URISyntaxException, IOException {

        Path fileName = Paths.get(this.getClass().getClassLoader().getResource("Texte/WelcomeText.txt").toURI());

        /*Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(String.valueOf(fileName)), "UTF-8"));
        try {
            out.write("I would like it to works plz");
        } finally {
            out.close();
        }

        PrintWriter writer = new PrintWriter(String.valueOf(fileName),"UTF-8");
        writer.print("bonsoir");
        writer.close();
    }*/

    public void changeText(Integer textID, String text){
        String sqlQuery = "UPDATE texts SET text=? WHERE textID=?;";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

                statement.setString(1, text);
                statement.setInt(2,textID);

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

