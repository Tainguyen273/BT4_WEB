package project_27_8_vidu1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project_27_8_vidu1.config.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/ForgotPassword")
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ForgotPasswordController() {
        super();
    }

    // Handle GET request (display the forgot password form)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ForgotPassword.jsp").forward(request, response);
    }

    // Handle POST request (process email and new password)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String newPassword = request.getParameter("password");
        String message;

        if (email == null || email.trim().isEmpty()) {
            message = "Vui lòng nhập email.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/ForgotPassword.jsp").forward(request, response);
            return;
        }

        DBConnection dbConnection = new DBConnection();
        try (Connection conn = dbConnection.getConnection()) {
            // Check if email exists in Users table
            String sql = "SELECT * FROM Users WHERE email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    if (newPassword != null && !newPassword.trim().isEmpty()) {
                        // Update password in Users table
                        String updateSql = "UPDATE Users SET password = ? WHERE email = ?";
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                            updateStmt.setString(1, newPassword); // In production, hash the password
                            updateStmt.setString(2, email);
                            updateStmt.executeUpdate();
                            message = "Mật khẩu đã được đặt lại thành công.";
                        }
                    } else {
                        // Email exists, show password reset form
                        request.setAttribute("email", email);
                        message = "Email hợp lệ. Vui lòng nhập mật khẩu mới.";
                    }
                } else {
                    // Email not found
                    message = "Email không tồn tại trong hệ thống.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = "Lỗi hệ thống, vui lòng thử lại sau.";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("/ForgotPassword.jsp").forward(request, response);
    }
}