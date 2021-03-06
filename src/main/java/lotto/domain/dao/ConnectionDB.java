package lotto.domain.dao;

import java.sql.*;

public class ConnectionDB {
    public static Connection getConnection() {
        Connection connection = null;
        String server = "localhost";
        String database = "lotto";
        String userName = "hyojae";
        String password = "0000";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false", userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet getResultSet(int round, String query) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1, round);
        return preparedStatement.executeQuery();
    }
}
