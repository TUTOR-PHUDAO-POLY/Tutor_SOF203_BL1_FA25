<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellpadding="10" cellspacing="0">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Giới tính</th>
        <th>Cân nặng</th>
        <th>Khu vực sống</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <%--    for(DongVat dv :listDongVat)--%>
    <tbody>
    <c:forEach items="${lists}" var="dv" varStatus="i">
        <tr>
            <td>${i.index +1}</td>
            <td>${dv.ma}</td>
            <td>${dv.ten}</td>
            <td>${dv.gioiTinh ? "Đực" :"Cái"}</td>
                <%--            <td>--%>
                <%--                <c:choose>--%>
                <%--                    <c:when test="${dv.gioiTinh}">Đực</c:when>--%>
                <%--                    <c:otherwise>Cái</c:otherwise>--%>
                <%--                </c:choose>--%>
                <%--            </td>--%>
            <td>${dv.canNang}</td>
            <td>${dv.khuVucSong}</td>
            <td>
                <a href="/dong-vat/view-update?id2=${dv.ma}">Update</a>
                <a href="/dong-vat/remove?id1=${dv.ma}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
