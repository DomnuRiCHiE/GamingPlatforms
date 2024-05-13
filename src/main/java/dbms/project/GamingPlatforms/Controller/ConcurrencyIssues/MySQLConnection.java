package dbms.project.GamingPlatforms.Controller.ConcurrencyIssues;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/GamingPlatforms";
    private static final String USER = "root";
    private static final String PASSWORD = "Baklava21";

    @Bean
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
