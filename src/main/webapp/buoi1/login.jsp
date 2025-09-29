<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 29/9/25
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${mess1}
<p style="color:red;">${error}</p>
<form method="POST" action="/ket-qua">
    Username: <input type="text" name="uname" ><br/><br/>
    Password: <input type="password" name="pass" ><br/><br/>
    <button type="submit">Login</button>
</form>
</body>
</html>
