<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Form search--%>
<form>
    Search: <input type="text" name="" placeholder="Ten hoac ma"/> <br/><br/>
    Can nang can nang min: <input type="text" name="" placeholder="can nang max"/> <br/><br/>
    Can nang max: <input type="text" name="" placeholder="Can nang min"/> <br/><br/>
    <button type="submit">Search</button>
</form>
<button><a href="/dong-vat/sort">Sắp xếp</a></button><br/><br/>
<button><a href="/dong-vat/filter">Lọc danh sách cân nặng</a></button><br/><br/>
<%--Form add--%>
<form action="/dong-vat/add" method="POST">
    Mã: <input type="text" name="ma" value="${dv1.ma}"/> <br/><br/>
    Khu vực sống:
    <select name="khuVucSong">
        <option value="Ha noi" ${dv1.khuVucSong eq "Ha noi" ? "selected":""}>Hà nội</option>
        <option value="Vinh phuc" ${dv1.khuVucSong eq "Vinh phuc" ? "selected":""}>Vĩnh phúc</option>
        <option value="Nghe an" ${dv1.khuVucSong eq "Nghe an" ? "selected":""}>Nghệ an</option>
        <option value="Phu tho" ${dv1.khuVucSong eq "Phu tho" ? "selected":""}>Phu tho</option>
        <option value="Ninh binh" ${dv1.khuVucSong eq "Ninh binh" ? "selected":""}>Ninh binh</option>
    </select> <br/><br/>
    Tên:<input type="text" name="ten" value="${dv1.ten}"/> <br/><br/>
    Cân nặng:<input type="text" name="canNang" value="${dv1.canNang}"/> <br/><br/>
    Giới tính:
    <%--    <input type="radio" name="gioiTinh" value="true" checked >Đực--%>
    <%--    <input type="radio" name="gioiTinh" value="false" >Cái--%>
    <%-- C:if--%>
<%--    <input type="radio" name="gioiTinh" value="true"--%>
<%--           <c:if test="${dv1.gioiTinh}">checked</c:if>--%>
<%--    >Đực--%>
<%--    <input type="radio" name="gioiTinh" value="false"--%>
<%--           <c:if test="${!dv1.gioiTinh}">checked</c:if>--%>
<%--    >Cái--%>
    <%--  Toan tu 3 ngoi  --%>
    <input type="radio" name="gioiTinh" value="true" ${dv1.gioiTinh ? "checked":""}/>Đực
    <input type="radio" name="gioiTinh" value="false" ${!dv1.gioiTinh ? "checked":""}/>Cái
        <br/><br/>
        <button type="submit">Add</button>
    </form>
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
                <a href="/dong-vat/detail?id2=${dv.ma}">Detail</a>
                <a href="/dong-vat/view-update?id2=${dv.ma}">Update</a>
                <a href="/dong-vat/remove?id1=${dv.ma}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
