<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kasyan.bean.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление продукта</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg" bgcolor="#CCFFCC">
<%@include file="../header.jsp"%>
<%@include file="nav.jsp"%>
<h2>Удаление продукта</h2>
<h3>Продукт удален  из корзины!!</h3>
<c:forEach items="${product}">
    <tr>
        <td colspan="2" align="center">product.getCategory()</td>
        <td colspan="2" align="center">product.getName()</td>
    </tr>
</c:forEach>
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
