package dbms.project.GamingPlatforms.Controller.ConcurrencyIssues;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/lostUpdate")
public class LostUpdate {

    @PostMapping()
    public void lostUpdate() {
        try (Connection connection = MySQLConnection.getConnection()) {

            int initialValue = getGamePrice(connection, "New Game");
            System.out.println("Initial Price: " + initialValue);

            Thread thread1 = new Thread(() -> updateGamePrice(connection, "New Game", initialValue + 10));
            Thread thread2 = new Thread(() -> updateGamePrice(connection, "New Game", initialValue - 20));

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            int finalValue = getGamePrice(connection, "New Game");
            System.out.println("Final Price: " + finalValue);
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int getGamePrice(Connection connection, String gameName) throws SQLException {
        String sql = "SELECT Price FROM Game WHERE Name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gameName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Price");
                } else {
                    throw new SQLException("Game not found");
                }
            }
        }
    }

    private static void updateGamePrice(Connection connection, String gameName, int newPrice) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String sql = "UPDATE Game SET Price = ? WHERE Name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newPrice);
            statement.setString(2, gameName);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Game not found");
            }
            System.out.println("Price updated successfully by Thread-" + Thread.currentThread().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
