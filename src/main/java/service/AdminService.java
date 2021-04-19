package service;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminService {
    public AdminService(){

    }
    private static final String SELECT_USER_BY_ID = "select customerid,name,password,email,wallet from customer where customerid =?;";
    private static final String UPDATE_CUSTOMERWALLET_SQL = "UPDATE casestudy.customer SET wallet = ? WHERE customerId = ?;";
    public boolean updateWalletcustomer (User user){
        boolean rowUpdate =  false;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMERWALLET_SQL);
            statement.setInt(1,user.getWallet());
            statement.setInt(2,user.getUserId());
            rowUpdate = statement.executeUpdate() >0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  rowUpdate;



    }public User selectUser(int id){
        User user = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int customerId = rs.getInt("customerId");
                int wallet = rs.getInt("wallet");
                user = new User(customerId,wallet);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    public static User selectUserChange(int id){
        User user = null;
        try {
            String sql = "select * from customer where customerid = ?;";
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                user = new User(id,name,email);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
