package Grambois.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public void createUser(String mail, String pwd){
        String sqlQuery = "INSERT INTO user(mail, pwd) VALUES (?,?);";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

                statement.setString(1, mail);
                statement.setString(2,pwd);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
