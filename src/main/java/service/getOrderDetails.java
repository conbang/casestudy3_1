package service;

import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getOrderDetails {
    String sql ="select orderdetail.key,orderdetail.priceunit from orderdetail join orders on orderdetail.orderId = orders.orderId where orders.customerId = ?;";
    public List<Orders> getOrderdetaiList(int id){
        List<Orders> ordersList = new ArrayList<>();

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String key = rs.getString("key");
                Float priceunit = rs.getFloat("priceunit");
                ordersList.add(new Orders(key,priceunit));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
      return ordersList;

    }

}
