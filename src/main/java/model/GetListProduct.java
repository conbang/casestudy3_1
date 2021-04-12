package model;

import service.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GetListProduct implements IGetProduct {

    @Override
    public List<Product> getListProduct(String type, String currency) {
        Connection connection = DatabaseConnection.getConnection();
        List<Product> listProduct = new LinkedList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, type);
                preparedStatement.setString(2, currency);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listProduct.add(new Product(resultSet.getString("type"),
                            resultSet.getFloat("value"),
                            resultSet.getInt("rate"),
                            resultSet.getString("currency"),
                            resultSet.getString("image")));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return listProduct;
    }
}
