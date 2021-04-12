package model;

import service.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Register implements IRegister {
    @Override
    public int register(String name, String email, String psw) {
        Connection conn = null;
        CallableStatement cstmt = null;
        int result = 0;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            cstmt = conn.prepareCall("{call register(?,?,?,?)}");
            cstmt.registerOutParameter(4, Types.INTEGER);
            cstmt.setString(1, name);
            cstmt.setString(2, email);
            cstmt.setString(3, psw);
            cstmt.executeQuery();
            conn.commit();
            result = cstmt.getInt(4);
            cstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
