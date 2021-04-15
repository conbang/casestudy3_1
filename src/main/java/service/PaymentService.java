package service;

import model.CartItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PaymentService {
    int customerId;
    int amount = 0;
    int wallet;
    List<CartItem> listItem = null;
    String updateWallet = "UPDATE customer SET wallet = ? WHERE (customerId = ?)";
    String insertBalancedetail = "INSERT INTO balancedetail (customerId,transaction,time) VALUES (?, ?, NOW())";
    String insertOrder = "INSERT INTO `casestudy`.`orders` (`customerId`, `status`, `orderDate`) VALUES (?, 'success', NOW());";
    String getOrderId = "select orderId from orders order by orderId desc limit 1";
    String insertOrderdetail = "INSERT INTO `casestudy`.`orderdetail` (`orderID`, `productId`,`priceunit`, `key`) VALUES (?, ?, ?,?)";
    String deleteItemCart = "DELETE FROM `casestudy`.`cart` WHERE (`customerId` = ?) and (`productId` = ?)";
    String getKey = "SELECT keyvalue FROM keyvalue WHERE productId=? LIMIT 1";
    String deleteKey = "DELETE keyvalue FROM keyvalue WHERE keyvalue= ?";

    public PaymentService(int customerId, int wallet) {
        this.wallet = wallet;
        this.customerId = customerId;
        listItem = new CartService().getListCartItem(customerId);
        for (int i = 0; i < listItem.size(); i++) {
            amount += listItem.get(i).getQuantity() * listItem.get(i).getProduct().getPrice();
        }
    }

    public void payment() {
        updateCart();
        insertOrder();
        insertOrderdetail();
        insertBalancedetail();
        transaction();
    }

    public void insertOrder() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(insertOrder);
                preparedStatement.setInt(1, customerId);
                preparedStatement.execute();
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
    }

    public void updateCart() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                for (int i = 0; i < listItem.size(); i++) {
                    PreparedStatement preparedStatement = connection.prepareStatement(deleteItemCart);
                    preparedStatement.setInt(1, customerId);
                    preparedStatement.setInt(2, listItem.get(i).getProduct().getProductId());
                    preparedStatement.executeUpdate();
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
    }

    public void insertOrderdetail() {
        String keygen = "";
        int orderId=0;
        Connection connection = DatabaseConnection.getConnection();
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = null;
                for (int i = 0; i < listItem.size(); i++) {
                    preparedStatement = connection.prepareStatement(getKey);
                    preparedStatement.setInt(1, listItem.get(i).getProduct().getProductId());
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        keygen = resultSet.getString("keyvalue");
                    }
                    preparedStatement = connection.prepareStatement(deleteKey);
                    preparedStatement.setString(1, keygen);
                    preparedStatement.executeUpdate();
                    preparedStatement=connection.prepareStatement(getOrderId);
                    resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        orderId=resultSet.getInt("orderId");
                    }
                    preparedStatement = connection.prepareStatement(insertOrderdetail);
                    preparedStatement.setInt(1, orderId);
                    preparedStatement.setInt(2, listItem.get(i).getProduct().getProductId());
                    preparedStatement.setInt(3, listItem.get(i).getProduct().getPrice());
                    preparedStatement.setString(4,keygen);
                    preparedStatement.executeUpdate();
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
    }

    public void transaction() {
        Connection connection = DatabaseConnection.getConnection();
        int x = wallet - amount;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(updateWallet);
                preparedStatement.setInt(1, x);
                preparedStatement.setInt(2, customerId);
                preparedStatement.executeUpdate();
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
    }

    public void insertBalancedetail() {
        Connection connection = DatabaseConnection.getConnection();
        int x = amount * -1;
        if (connection != null) {
            try {
                for (int i = 0; i < listItem.size(); i++) {
                    PreparedStatement preparedStatement = connection.prepareStatement(insertBalancedetail);
                    preparedStatement.setInt(1, customerId);
                    preparedStatement.setInt(2, x);
                    preparedStatement.executeUpdate();
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
    }
}
