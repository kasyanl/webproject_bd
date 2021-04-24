<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Учет продуктов</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg"
      bgcolor="#CCFFCC">
<%@include file="../header.jsp" %>
<%@include file="nav.jsp" %>
<h1>Система учета продуктов</h1>

<table class="table" align="center">
    <tr>
        <th width="100" align="center">
            <a href="${pageContext.request.contextPath}/product/allproduct">
                <img src="https://png.pngtree.com/png-vector/20190719/ourlarge/pngtree-document-icon-for-your-project-png-image_1549479.jpg"
                     width="400" height="400" alt="Список всех продуктов"><h3>Список всех продуктов</h3></a></p>
        </th>
        <th width="100" align="center">
            <a href="${pageContext.request.contextPath}/product/addproduct">
                <img src="https://im0-tub-ru.yandex.net/i?id=69223af99e70d4096a92dcb39760d752&ref=rim&n=33&w=150&h=150"
                     width="400" height="400" alt="Добавить новый продукт"><h3>Добавить новый продукт</h3></a></p>
        </th>
    </tr>
    <tr>
        <th width="100" align="center"></th>
        <th width="100" align="center"></th>
    </tr>
</table>

<%@include file="../footer.jsp" %>
</body>
</html>
