<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Система учета продуктов</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg" bgcolor="#CCFFCC">
<%@include file="../header.jsp"%>
<%@include file="navguest.jsp"%>
<h1>Выберите категориию:</h1>
<div face="arial" size="+1">
    <li><a href="${pageContext.request.contextPath}/product/finefruitsguest">FRUITS</a>
    <li><a href="${pageContext.request.contextPath}/product/fineberriesguest">BERRIES</a>
    <li><a href="${pageContext.request.contextPath}/product/finevegetablesguest">VEGETABLES</a>
    <li><a href="${pageContext.request.contextPath}/product/finemilkproductguest">MILK_PRODUCT</a>
    <li><a href="${pageContext.request.contextPath}/product/finemeatguest">MEAT</a>
    <li><a href="${pageContext.request.contextPath}/product/finealcoholguest">ALCOHOLIC_BEVERAGES</a>
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