package Grambois.services;

import Grambois.dao.TextDAO;

import java.io.IOException;
import java.net.URISyntaxException;

public class TextService {
    private static TextService ourInstance = new TextService();

    public static TextService getInstance() {
        return ourInstance;
    }

    private TextService() {
    }

    private TextDAO textDAO = new TextDAO();

    public String getText(int textID){
        String text = "";
        text = textDAO.getText(textID);
        return  text;
    }

    public  void  changeText(Integer textID, String newText){
        textDAO.changeText(textID,newText);

    }
}
