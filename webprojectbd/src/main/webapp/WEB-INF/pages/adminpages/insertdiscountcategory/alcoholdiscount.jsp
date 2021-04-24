<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение данных.</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg" bgcolor="#CCFFCC">
<%@include file="../../header.jsp"%>
<%@include file="../nav.jsp"%>
<h2>Установите новую единую скидку для категории ALCOHOLIC_BEVERAGES:</h2>
<form action="${pageContext.request.contextPath}/product/alcoholdiscount" method="post">
    Новая скидка:<br>
    <label><input name="discount" placeholder="Скидка, %" type="text"></label>
    <br> <input type="image" src="https://localmarketing.university/wp-content/uploads/2016/09/save-file_z1uSqULO_L.jpg"
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