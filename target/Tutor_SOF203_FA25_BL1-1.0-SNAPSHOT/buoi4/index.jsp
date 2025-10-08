<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 8/10/25
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>STT</th>
            <th>Code</th>
            <th>Name</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="cate" items="${list}" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${cate.categoryCode}</td>
            <td>${cate.categoryName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
