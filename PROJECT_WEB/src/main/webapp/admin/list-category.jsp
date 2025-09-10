<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý danh mục</title>
    <style>
        body { font-family: Arial, sans-serif; background: #e9ecef; margin: 0; padding: 0; }
        .container {
            max-width: 1000px;
            margin: 20px auto;
            background: #ffffff;
            border: 2px solid #2c3e50;
            border-radius: 5px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
        }
        .header {
            background: #2c3e50;
            color: white;
            padding: 15px;
            text-align: center;
            border-bottom: 2px solid #34495e;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .user-info {
            margin-left: 15px;
            text-align: left;
        }
        .avatar {
            width: 50px;
            height: 50px;
            border-radius: 50%;
            object-fit: cover;
            margin-right: 10px;
        }
        .content {
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:nth-child(even) { background-color: #f9f9f9; }
        tr:hover { background-color: #f1f1f1; }
        td img {
            max-height: 150px;
            max-width: 200px;
            transition: transform 0.2s;
        }
        td img:hover { transform: scale(1.05); }
        .message { color: #28a745; margin: 10px 0; }
        .error { color: #dc3545; margin: 10px 0; }
        .action-btn, .add-btn, .logout-btn {
            display: inline-block;
            padding: 8px 15px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-right: 5px;
        }
        .action-btn { background: #007bff; }
        .action-btn:hover { background: #0056b3; }
        .add-btn { background: #28a745; }
        .add-btn:hover { background: #218838; }
        .logout-btn { background: #e74c3c; }
        .logout-btn:hover { background: #c0392b; }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <c:if test="${not empty sessionScope.account}">
                <c:choose>
                    <c:when test="${not empty sessionScope.account.avatar}">
                        <c:url value="/image?fname=${sessionScope.account.avatar}" var="avatarUrl"></c:url>
                        <img src="${avatarUrl}" alt="Avatar" class="avatar"/>
                    </c:when>
                    <c:otherwise>
                        <img src="<c:url value='/images/default-avatar.jpg'/>" alt="Default Avatar" class="avatar"/>
                    </c:otherwise>
                </c:choose>
                <div class="user-info">
                    <h2>Chào mừng Admin, ${sessionScope.account.fullName}!</h2>
                </div>
            </c:if>
        </div>
        <div class="content">
            <!-- Hiển thị thông báo -->
            <c:if test="${not empty param.message}">
                <p class="message">${param.message == 'deleteSuccess' ? 'Xóa danh mục thành công!' : param.message}</p>
            </c:if>
            <c:if test="${not empty param.error}">
                <p class="error">${param.error}</p>
            </c:if>

            <!-- Bảng danh sách danh mục -->
            <table>
                <tr>
                    <th>STT</th>
                    <th>Hình ảnh</th>
                    <th>Tên danh mục</th>
                    <th>Hành động</th>
                </tr>
                <c:choose>
                    <c:when test="${not empty cateList}">
                        <c:forEach items="${cateList}" var="cate" varStatus="STT">
                            <tr class="odd gradeX">
                                <td>${STT.index + 1}</td>
                                <td>
                                    <c:if test="${not empty cate.icon}">
                                        <c:url value="/image?fname=${cate.icon}" var="imgUrl"></c:url>
                                        <img height="150" width="200" src="${imgUrl}" alt="Icon"/>
                                    </c:if>
                                </td>
                                <td>${cate.catename}</td>
                                <td>
                                    <a href="<c:url value='/admin/category/edit?id=${cate.cateid}'/>" class="action-btn">Sửa</a>
                                    |
                                    <form action="<c:url value='/admin/category/delete'/>" method="post" style="display:inline;">
                                        <input type="hidden" name="id" value="${cate.cateid}">
                                        <input type="submit" value="Xóa" class="action-btn" onclick="return confirm('Bạn có chắc muốn xóa danh mục này?');">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="4">Không có danh mục nào.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>

            <!-- Liên kết thêm danh mục và đăng xuất -->
            <div style="margin-top: 20px;">
                <a href="<c:url value='/admin/category/add'/>" class="add-btn">Thêm danh mục</a>
                <c:if test="${not empty sessionScope.account}">
                    <a href="<c:url value='/logout'/>" class="logout-btn">Đăng xuất</a>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>