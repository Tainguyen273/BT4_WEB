package project_27_8_vidu1.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String serverName = "localhost";
    private final String portNumber = "1433"; 
    private final String dbName = "THWEB_27_8";
    private final String userID = "sa";
    private final String password = "123456";

    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                   + ";databaseName=" + dbName
                   + ";encrypt=true;trustServerCertificate=true";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQL Server JDBC Driver not found.", e);
        }

        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try (Connection c = new DBConnection().getConnection()) {
            System.out.println("✅ Kết nối thành công: " + (c != null && !c.isClosed()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
