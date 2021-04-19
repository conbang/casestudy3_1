package service;

import model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class getOrders implements IGetOrders{
    public getOrders() {
    }

    public List<Orders> getListOrders(int customerid){
        List <Orders> ordersList = new ArrayList<>();
        try {Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,customerid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("orderId");
                String status = rs.getString("status");
                Date orderDate = rs.getDate("orderDate");
                ordersList.add(new Orders(id,status,orderDate));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ordersList;
    }
}
