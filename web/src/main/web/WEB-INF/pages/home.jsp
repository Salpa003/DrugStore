<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
This is home
<c:forEach var="product" items="${products}">
    <li>${product}</li>
</c:forEach>
</body>
</html>
