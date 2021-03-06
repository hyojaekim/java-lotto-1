package lotto.domain.dao;

import java.sql.*;

public class RoundDAO {
    private static final Connection connection = ConnectionDB.getConnection();

    public static void registerCount() throws SQLException {
        String query = "INSERT INTO round(round) SELECT ifnull(MAX(round) + 1, 1) FROM round";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public static int searchMaxCount() throws SQLException {
        String query = "SELECT MAX(round) FROM round";
        Statement psmt = connection.createStatement();
        ResultSet resultSet = psmt.executeQuery(query);
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        throw new SQLException();
    }
}
