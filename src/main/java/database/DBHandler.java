package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
    private Connection connection;
    private final String DB_TYPE = "jdbc:mysql://";
    private final String DB_HOST = "localhost:";
    private final String DB_PORT = "3306/";
    private final String MY_SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String MY_DB_NAME = "mydbtest";
    private static final String TIME_ZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=" +
            "true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "aleksandra";

    public DBHandler() {
       this.connection = openConnection();
    }

    private Connection openConnection() {
        try {
            Driver driver = (Driver) Class.forName(MY_SQL_DRIVER).newInstance();
            DriverManager.registerDriver(driver);
            StringBuilder url = new StringBuilder();
            url.append(DB_TYPE)
                    .append(DB_HOST)
                    .append(DB_PORT)
                    .append(MY_DB_NAME)
                    .append(TIME_ZONE);
            return DriverManager.getConnection(url.toString(), USER, PASSWORD);
        } catch (ClassNotFoundException | IllegalAccessException |
                InstantiationException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() {
        return connection;
    }
}
