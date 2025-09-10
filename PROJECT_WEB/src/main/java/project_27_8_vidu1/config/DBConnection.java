package project_27_8_vidu1.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    private final String serverName = "localhost";
    private final String dbName = "THWeb_27_8";
    private final String portNumber = "1433";
    private final String instance = ""; // "SQLEXPRESS" nếu có instance

    public Connection getConnection() throws SQLException {
        String url;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber +
                  ";databaseName=" + dbName +
                  ";integratedSecurity=true;encrypt=true;trustServerCertificate=true";
        } else {
            url = "jdbc:sqlserver://" + serverName + "\\" + instance +
                  ";databaseName=" + dbName +
                  ";integratedSecurity=true;encrypt=true;trustServerCertificate=true";
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQL Server JDBC Driver không được tìm thấy.", e);
        }

        return DriverManager.getConnection(url);
    }

//    public static void main(String[] args) {
//    	try {
//            // Kết nối với Windows Authentication + bỏ qua kiểm tra SSL
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=THWeb_27_8;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
//            Connection conn = DriverManager.getConnection(url);
//
//            Statement stmt = conn.createStatement();
//
//            // Insert dữ liệu
//
//            // Lấy dữ liệu
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
//            while (rs.next()) {
//                System.out.println(rs.getInt("id") + " " + rs.getString("username") + " " + rs.getString("password"));
//            }
//
//            conn.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}
