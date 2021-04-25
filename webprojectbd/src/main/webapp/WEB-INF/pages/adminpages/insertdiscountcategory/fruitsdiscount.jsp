<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение данных.</title>
</head>
<body align="center" background="${pageContext.request.contextPath}/download/xls/bg.jpg" bgcolor="#CCFFCC">
<%@include file="../../header.jsp"%>
<%@include file="../nav.jsp"%>
<h2>Установите новую единую скидку для категории FRUITS:</h2>
<form action="${pageContext.request.contextPath}/product/fruitsdiscount" method="post">
    Новая скидка:<br>
    <label><input name="discount" placeholder="Скидка, %" type="text"></label>
    <br> <input type="image" src="${pageContext.request.contextPath}/download/xls/save.jpg"
                width="50" height="50" alt="Добавить новый продукт" value="Сохранить">
    <br>
</form>
<a href="${pageContext.request.contextPath}/content">Home</a>
<br>
<br>
<br>
<%@include file="../../footer.jsp"%>
<br>
<br>
</html>