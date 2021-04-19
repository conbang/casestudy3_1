package service;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindAllUser {
    public List<User> findAllUser(){
        List<User> result = new ArrayList<>();
        String sql = "select * from customer;";
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null){
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while(resultSet.next()){
                    User user = new User();
                    user.setUserId(resultSet.getInt("customerId"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setWallet(resultSet.getInt("wallet"));
                    result.add(user);

                }

                return result;

            } catch (SQLException e) {
                return null;
            }
            finally {
                try{
                    if(connection != null){
                        connection.close();
                    }
                    if(statement != null){
                        statement.close();
                    }
                    if(resultSet !=null){
                        resultSet.close();
                    }}
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    }

