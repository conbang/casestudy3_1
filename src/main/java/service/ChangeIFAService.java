package service;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeIFAService {
    private static final String sql = "update customer set password = ? where customerid = ?;";
    public void changeInformationAcc(int id,String pass){
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,pass);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }



    }
}
