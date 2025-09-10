<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên Mật Khẩu</title>
    <style>
        /* General body styling */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
            color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            text-align: center;
        }

        /* Container for the form */
        .card {
            background-color: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.37);
            border: 1px solid rgba(255, 255, 255, 0.18);
            width: 90%;
            max-width: 400px;
        }

        /* Header styling */
        h2 {
            margin-bottom: 25px;
            color: #ffffff;
            font-weight: 300;
        }

        /* Form styling */
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        /* Input field styling */
        .input-group {
            position: relative;
            margin-bottom: 15px;
        }

        .input-group label {
            text-align: left;
            display: block;
            margin-bottom: 5px;
            font-size: 0.9rem;
            color: #c0c0c0;
        }

        input[type="email"], input[type="password"] {
            width: 100%;
            padding: 12px;
            background-color: rgba(255, 255, 255, 0.1);
            border: 1px solid rgba(255, 255, 255, 0.3);
            border-radius: 8px;
            color: #ffffff;
            font-size: 1rem;
            transition: all 0.3s ease;
        }

        input[type="email"]:focus, input[type="password"]:focus {
            outline: none;
            border-color: #4CAF50;
            box-shadow: 0 0 8px rgba(76, 175, 80, 0.5);
        }

        /* Placeholder color */
        ::placeholder {
            color: #a0a0a0;
        }

        /* Submit button styling */
        input[type="submit"] {
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 1rem;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
            transform: translateY(-2px);
        }

        /* Message styling */
        .message {
            font-weight: 500;
            margin-bottom: 20px;
            animation: fadeIn 0.5s ease-in-out;
        }

        .message.error {
            color: #FF6B6B; /* Màu đỏ */
        }
        
        .message.success {
            color: #72f472; /* Màu xanh lá cây */
        }
        
        /* Link styling */
        .back-link {
            color: #a0a0f0;
            text-decoration: none;
            margin-top: 20px;
            display: block;
            transition: color 0.3s ease;
        }

        .back-link:hover {
            color: #72a4f4;
            text-decoration: underline;
        }

        /* Responsive design */
        @media (max-width: 480px) {
            .card {
                padding: 30px 20px;
            }
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>Quên Mật Khẩu</h2>
        <% 
            String message = (String) request.getAttribute("message");
            String status = (String) request.getAttribute("messageStatus");
            if (message != null) { 
        %>
            <p class="message <%= (status != null && status.equals("success")) ? "success" : "error" %>"><%= message %></p>
        <% } %>
        <form action="ForgotPassword" method="post">
            <div class="input-group">
                <label for="email">Nhập email của bạn:</label>
                <input type="email" id="email" name="email" value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>" required>
            </div>
            <% if (request.getAttribute("email") != null) { %>
                <div class="input-group">
                    <label for="password">Nhập mật khẩu mới:</label>
                    <input type="password" id="password" name="password" required>
                </div>
            <% } %>
            <input type="submit" value="<%= request.getAttribute("email") != null ? "Đặt Lại Mật Khẩu" : "Kiểm Tra Email" %>">
        </form>
        <a href="login.jsp" class="back-link">Quay lại đăng nhập</a>
    </div>
</body>
</html>