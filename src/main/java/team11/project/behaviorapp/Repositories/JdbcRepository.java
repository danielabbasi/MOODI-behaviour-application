package team11.project.behaviorapp.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class JdbcRepository {

    public static Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/behaviourdb", "root", "comsc");
    }
}