<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Nhập</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f0f2f5;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .login-container {
        background: #fff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        width: 350px;
    }
    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }
    .alert {
        color: #fff;
        background: #e74c3c;
        padding: 10px;
        text-align: center;
        border-radius: 5px;
        margin-bottom: 15px;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .form-control {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        outline: none;
        transition: 0.2s;
    }
    .form-control:focus {
        border-color: #3498db;
    }
    .form-actions {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    button {
        background: #3498db;
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        transition: 0.2s;
    }
    button:hover {
        background: #2980b9;
    }
    a {
        text-decoration: none;
        color: #3498db;
        font-size: 14px;
    }
    a:hover {
        text-decoration: underline;
    }
    .register-link {
        text-align: center;
        margin-top: 15px;
        font-size: 14px;
    }
</style>
</head>
<body>
    <div class="login-container">
        <form action="login" method="post">
            <h2>Đăng Nhập</h2>

            <c:if test="${alert != null}">
                <div class="alert">${alert}</div>
            </c:if>

            <div class="form-group">
                <input type="text" placeholder="Tài khoản" name="username" class="form-control">
            </div>
            <div class="form-group">
                <input type="password" placeholder="Mật khẩu" name="password" class="form-control">
            </div>

            <div class="form-actions">
                <label><input type="checkbox" name="remember"> Nhớ tôi</label>
                <a href="ForgotPassword.jsp">Quên mật khẩu?</a>
            </div>
	
            <div class="form-group" style="margin-top: 15px;">
                <button type="submit">Đăng nhập</button>
            </div>

            <div class="register-link">
                Nếu bạn chưa có tài khoản, hãy <a href="register">Đăng ký</a>
            </div>
        </form>
    </div>
</body>
</html>
