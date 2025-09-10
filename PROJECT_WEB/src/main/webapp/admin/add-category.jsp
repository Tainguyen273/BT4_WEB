<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        .form-control { width: 100%; padding: 5px; }
        .btn { padding: 5px 15px; margin-right: 10px; }
        .btn-default { background-color: #28a745; color: white; border: none; }
        .btn-primary { background-color: #007bff; color: white; border: none; }
        .error { color: red; }
    </style>
</head>
<body>
    <h2>Thêm danh mục</h2>
    
    <!-- Hiển thị thông báo lỗi -->
    <c:if test="${not empty message}">
        <p class="error">${message}</p>
    </c:if>

    <!-- Biểu mẫu thêm danh mục -->
    <form role="form" action="<c:url value='/admin/category/add'/>" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>Tên danh mục:</label>
            <input class="form-control" placeholder="Vui lòng nhập tên danh mục" name="name" 
                   value="${not empty category ? category.catename : ''}" required/>
        </div>
        <div class="form-group">
            <label>Ảnh đại diện:</label>
            <input type="file" name="icon"/>
        </div>
        <button type="submit" class="btn btn-default">Thêm</button>
        <a href="<c:url value='/admin/category/list'/>" class="btn btn-primary">Hủy</a>
    </form>
</body>
</html>