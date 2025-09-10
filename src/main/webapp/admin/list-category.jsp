<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý danh mục</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .message { color: green; }
        .error { color: red; }
        img { max-height: 150px; max-width: 200px; }
    </style>
</head>
<body>
    <h2>Quản lý danh mục</h2>
    
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
                            <a href="<c:url value='/admin/category/edit?id=${cate.cateid}'/>" class="center">Sửa</a>
                            |
                            <form action="<c:url value='/admin/category/delete'/>" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="${cate.cateid}">
                                <input type="submit" value="Xóa" onclick="return confirm('Bạn có chắc muốn xóa danh mục này?');">
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

    <!-- Liên kết thêm danh mục -->
    <p><a href="<c:url value='/admin/category/add'/>">Thêm danh mục</a></p>
</body>
</html>