package model;

import service.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Cart implements ICart{
    Connection conn = null;
    CallableStatement cstmt = null;
    @Override
    public boolean addNewProduct(int customerId, int productId, int total) {
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            cstmt = conn.prepareCall("{call addcart(?,?,?)}");
            cstmt.setInt(1, customerId);
            cstmt.setInt(2, productId);
            cstmt.setInt(3, total);
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
        return false;
    }
}
