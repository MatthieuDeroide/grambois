package Grambois.services;

import Grambois.dao.TextDAO;

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
        try {
            text = textDAO.getText(textID);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return  text;
    }
}
