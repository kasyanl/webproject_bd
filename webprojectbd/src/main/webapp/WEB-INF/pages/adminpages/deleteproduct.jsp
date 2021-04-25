<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kasyan.bean.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление продукта</title>
</head>
<body align="center" background="${pageContext.request.contextPath}/download/xls/bg.jpg" bgcolor="#CCFFCC">
<%@include file="../header.jsp"%>
<%@include file="nav.jsp"%>
<h3>Продукт  удален!!</h3>
<form action="${pageContext.request.contextPath}/product/allproduct?id=${product.getId()}" method="get">
    <input type="submit" value="Список продуктов">
</form>
<form action="${pageContext.request.contextPath}/product/alldeletedproduct" method="get">
    <input type="submit" value="Восстановить запись">
</form>
<%@include file="../footer.jsp"%>
<br>
<br>
</body>
</html>
