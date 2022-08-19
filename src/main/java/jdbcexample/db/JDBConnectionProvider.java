package jdbcexample.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnectionProvider {
    private static JDBConnectionProvider instance = new JDBConnectionProvider();

    private Connection connection;

    private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/user?characterEncoding=latin1&useConfigs=maxPerformance";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";


    private JDBConnectionProvider() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static JDBConnectionProvider getInstance() {
        return instance;
    }

    public Connection getConnection()   {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
