package service;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GetListProduct implements IGetProduct {

    @Override
    public List<Product> getListProduct() {
        Connection connection = DatabaseConnection.getConnection();
        List<Product> listProduct = new LinkedList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listProduct.add(new Product(
                            resultSet.getInt("id"),
                            resultSet.getString("type"),
                            resultSet.getFloat("value"),
                            resultSet.getInt("rate"),
                            resultSet.getString("currency"),
                            resultSet.getString("image")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return listProduct;
    }
}
