package dev.yurilopes.dao;

import dev.yurilopes.config.database.MySQLConnectionFactory;
import dev.yurilopes.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public void save(UserModel user) {
        String sql = "INSERT INTO users(name, email, password) VALUES(?, ?, ?)";

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = MySQLConnectionFactory.recoverConnection();

            pstm = (PreparedStatement) connection.prepareStatement(sql);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPassword());

            pstm.execute();

        } catch (Exception e) {

            throw new RuntimeException(e);

        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update(UserModel userModel) {
        String sql = "UPDATE users set password = ?" +
                "WHERE id = ?";

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = MySQLConnectionFactory.recoverConnection();
            pstm = (PreparedStatement) connection.prepareStatement(sql);

            pstm.setString(1, userModel.getPassword());
            pstm.setInt(2, userModel.getId());
            pstm.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            connection = MySQLConnectionFactory.recoverConnection();
            pstm = (PreparedStatement) connection.prepareStatement(sql);

            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}