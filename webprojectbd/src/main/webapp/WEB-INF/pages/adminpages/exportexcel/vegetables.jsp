<%--
  Created by IntelliJ IDEA.
  User: kasya
  Date: 09.04.2021
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg" bgcolor="#CCFFCC">
<%@include file="../../header.jsp"%>
<%@include file="../nav.jsp"%>
<h3>Список список категории <b>VEGETABLES</b> успешно сформирован. Нажмите на значок, для скачивания</h3>
<a href="${pageContext.request.contextPath}/download/xls/productlist.xls" title="Сохранить">
    <input type="image" src="https://macadmins.software/icons/excel.png"
           width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a>
<br>
<br>
<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../../footer.jsp"%>
<br>
<br>
</body>
</html>