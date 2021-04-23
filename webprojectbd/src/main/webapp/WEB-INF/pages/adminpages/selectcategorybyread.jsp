<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Система учета продуктов</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg" bgcolor="#CCFFCC">
<%@include file="../header.jsp"%>
<%@include file="nav.jsp" %>
<h1>Выберите категориию:</h1>
<div face="arial" size="+1">
    <li><a href="${pageContext.request.contextPath}/product/finefruits" target="content">FRUITS</a>
    <li><a href="${pageContext.request.contextPath}/product/fineberries" target="content">BERRIES</a>
    <li><a href="${pageContext.request.contextPath}/product/finevegetables" target="content">VEGETABLES</a>
    <li><a href="${pageContext.request.contextPath}/product/finemilkproduct" target="content">MILK_PRODUCT</a>
    <li><a href="${pageContext.request.contextPath}/product/finemeat" target="content">MEAT</a>
    <li><a href="${pageContext.request.contextPath}/product/finealcohol" target="content">ALCOHOLIC_BEVERAGES</a>
</div>
<br>
<br>
<a href="${pageContext.request.contextPath}/content" target="content">Back</a>
<br>
<br>
<%@include file="../footer.jsp"%>
<br>
<br>
</body>
</html>