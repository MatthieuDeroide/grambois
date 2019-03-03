package Grambois.services;

import Grambois.dao.UserDAO;
import Grambois.pojos.User;

import java.sql.SQLException;

public class UserService {
    private static UserService ourInstance = new UserService();

    public static UserService getInstance() {
        return ourInstance;
    }

    private UserService() {
    }

    private UserDAO userDAO = new UserDAO();

    public void createUser(String mail, String pwd){
        userDAO.createUser(mail,pwd);
    }

    public User getUser(String mail){
        return userDAO.getUser(mail);
    }
}
