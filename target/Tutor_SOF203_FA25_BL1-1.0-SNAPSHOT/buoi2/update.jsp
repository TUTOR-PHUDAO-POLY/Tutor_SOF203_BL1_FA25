<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 3/10/25
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dong-vat/update?ma1=${dv1.ma}" method="POST">
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
  <input type="radio" name="gioiTinh" value="true" ${dv1.gioiTinh ? "checked":""}/>Đực
  <input type="radio" name="gioiTinh" value="false" ${!dv1.gioiTinh ? "checked":""}/>Cái
  <br/><br/>
  <button type="submit">Update</button>
</form>
</body>
</html>
