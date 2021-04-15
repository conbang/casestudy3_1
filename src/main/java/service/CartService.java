package service;

import model.CartItem;
import model.Product;
import model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CartService implements ICart {
    Connection conn = null;
    CallableStatement cstmt = null;
    @Override
    public boolean addNewItem(int customerId, int productId) {
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            cstmt = conn.prepareCall("{call addcart(?,?,?)}");
            cstmt.setInt(1, customerId);
            cstmt.setInt(2, productId);
            cstmt.setInt(3, 1);
            cstmt.executeQuery();
            conn.commit();
            cstmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public boolean addQuantity(int customerId, int productId, int total) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATEQUANTITYQUERY);
                preparedStatement.setInt(1, total);
                preparedStatement.setInt(2,customerId);
                preparedStatement.setInt(3,productId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
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
        return true;
    }

    @Override
    public boolean deleteItem(int customerId, int productId) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETEITEMQUERY);
                preparedStatement.setInt(1, customerId);
                preparedStatement.setInt(2,productId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
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
        return true;
    }

    @Override
    public List<CartItem> getListCartItem(int customerID) {
        Connection connection = DatabaseConnection.getConnection();
        List<CartItem> listItem = new LinkedList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(GETLISTITEMQUERY);
                preparedStatement.setInt(1, customerID);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listItem.add(new CartItem(new Product(
                            resultSet.getInt("id"),
                            resultSet.getString("type"),
                            resultSet.getInt("value"),
                            resultSet.getInt("rate"),
                            resultSet.getString("currency"),
                    resultSet.getString("image")
                    ),resultSet.getInt("quantity")));
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
        return listItem;
    }
}
