<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Касса</title>
</head>
<body align="center" background="${pageContext.request.contextPath}/download/xls/bg.jpg" bgcolor="#CCFFCC">
<%@include file="../header.jsp"%>
<%@include file="nav.jsp"%>
<h3>Перейти к этапу выбора товаров?</h3>

<form action="${pageContext.request.contextPath}/product/allproduct" method="get">
    <input type="submit" value="Список продуктов">
</form>
<form action="${pageContext.request.contextPath}/product/buyproduct" method="get">
    <input type="submit" value="В кассу">
</form>
<%@include file="../footer.jsp"%>
<br>
<br>
</body>
</html>
