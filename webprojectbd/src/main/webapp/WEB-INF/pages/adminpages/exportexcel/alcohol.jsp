<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body align="center" background="${pageContext.request.contextPath}/download/xls/bg.jpg" bgcolor="#CCFFCC">
<%@include file="../../header.jsp" %>
<%@include file="../nav.jsp" %>
<h3>Список список категории ALCOHOLIC_BEVERAGES успешно сформирован. Нажмите на значок, для скачивания</h3>
<a href="${pageContext.request.contextPath}/download/xls/productlist.xls" title="Сохранить">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/excel.png"
           width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a>
<br>
<br>
<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../../footer.jsp" %>
<br>
<br>
</body>
</html>
