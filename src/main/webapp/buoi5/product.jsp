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
<select>
    <c:forEach var="c" items="${listCate}" >
        <option value="${c.id}">${c.categoryName}</option>
    </c:forEach>
</select>
<table border="1" cellspacing="0" cellpadding="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>P.Code</th>
        <th>P.Name</th>
        <th>P.Price</th>
        <th>P.Desciption</th>
        <th>C.Code</th>
        <th>C.Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${listProduct}" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${p.productCode}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
            <td>${p.cate.categoryCode}</td>
            <td>${p.cate.categoryName}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
