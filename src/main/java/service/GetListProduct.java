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
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listProduct.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getInt("value"),
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

    public LinkedList<Product> getListBestSeller(){
            Connection connection = DatabaseConnection.getConnection();
            LinkedList<Product> listProduct = new LinkedList<>();
            LinkedList<Integer> listIdProduct = new LinkedList<>();
            if (connection != null) {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(GETIDLISTBESTSELLER);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        listIdProduct.add(resultSet.getInt("productId"));
                    }
                    preparedStatement = connection.prepareStatement(GETLISTBESTSELLER);
                    for (int i = 1; i <= listIdProduct.size(); i++) {
                        preparedStatement.setInt(i,listIdProduct.get(i-1));
                    }
                    resultSet=preparedStatement.executeQuery();
                    while (resultSet.next()){
                        listProduct.add(new Product(resultSet.getInt("id"),
                                resultSet.getString("type"),
                                resultSet.getInt("value"),
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
