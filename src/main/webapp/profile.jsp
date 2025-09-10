<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%
    project_27_8_vidu1.models.User account = (project_27_8_vidu1.models.User) session.getAttribute("account");
    if (account == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hồ sơ</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <style>
        .avatar-preview { width: 150px; height: 150px; object-fit: cover; border-radius: 50%; }
    </style>
    <decorator:head/>
    <decorator:title default="Profile"/>
    <decorator:body/>
</head>
<body>
<div class="container py-4">
    <h3 class="mb-4">Cập nhật hồ sơ</h3>
    <div class="row">
        <div class="col-md-4 text-center">
            <img class="avatar-preview mb-3" src="<c:out value='${account.avatar != null ? account.avatar : "images/default-avatar.jpg"}'/>" alt="Avatar">
            <p class="text-muted"><c:out value="${account.email}"/></p>
        </div>
        <div class="col-md-8">
            <form method="post" action="${pageContext.request.contextPath}/profile" enctype="multipart/form-data" class="needs-validation" novalidate>
                <div class="mb-3">
                    <label class="form-label">Họ và tên</label>
                    <input type="text" class="form-control" name="fullname" value="<c:out value='${account.fullName}'/>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Số điện thoại</label>
                    <input type="text" class="form-control" name="phone" value="<c:out value='${account.phone}'/>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Ảnh đại diện</label>
                    <input type="file" class="form-control" name="image" accept="image/*">
                </div>
                <button class="btn btn-primary" type="submit">Lưu thay đổi</button>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


