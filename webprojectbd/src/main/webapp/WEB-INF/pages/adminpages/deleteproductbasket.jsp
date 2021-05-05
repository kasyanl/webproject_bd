<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление продукта</title>
    <style>
        body {
            background-color: #CCFFCC;
            background-image: url(${pageContext.request.contextPath}/download/xls/bg.jpg);
        }
    </style>
</head>
<body align="center">
<%@include file="../header.jsp"%>
<%@include file="nav.jsp"%>
<h2>Удаление продукта</h2>
<h3>Продукт удален из корзины!!</h3>

<form action="${pageContext.request.contextPath}/product/allproduct?id=${product.getId()}" method="get">
    <input type="submit" value="Список продуктов">
</form>
<form action="${pageContext.request.contextPath}/product/alldeletedproduct" method="get">
    <input type="submit" value="в корзину">
</form>
<%@include file="../footer.jsp"%>
<br>
<br>
</body>
</html>
