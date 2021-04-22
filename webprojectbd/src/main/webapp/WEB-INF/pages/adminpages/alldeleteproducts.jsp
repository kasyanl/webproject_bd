<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Корзина</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg"
      bgcolor="#CCFFCC">
<%@include file="../header.jsp" %>
<%@include file="nav.jsp" %>
<h1>Весь список удаленных ранее продуктов</h1>

<h3 align="right"><a href="${pageContext.request.contextPath}/exportexceldel">Экспорт в Excel файл</a></h3>

<table class="table" align="center">
    <tr>
        <th width="100" align="center"><b> ID</b></th>
        <th align="center"><b> категория</b></th>
        <th align="center"><b> название</b></th>
        <th width="100" align="center"><b> цена</b></th>
        <th width="100" align="center"><b> скидка</b></th>
        <th width="100" align="center"><b> конечная цена</b></th>
        <th align="center"><b> дата удаления</b></th>
        <td></td>
        <td></td>
    </tr>
    <c:forEach var="product" items="${product}">
        <tr>
            <td align="center"><c:out value="${product.getId()}"/></td>
            <td align="center"><c:out value="${product.getCategory()}"/></td>
            <td align="center"><c:out value="${product.getName()}"/></td>
            <td align="center"><c:out value="${product.getPrice()}"/></td>
            <td align="center"><c:out value="${product.getDiscount()}"/></td>
            <td align="center"><c:out value="${product.getActualPrice()}"/></td>
            <td align="center"><c:out value="${product.getData()}"/></td>
            <td align="center"><a href="${pageContext.request.contextPath}/product/recoveredproduct?id=${product.getId()}">Восстановить</a>
            <td align="center"><a href="${pageContext.request.contextPath}/product/deleteproductbasket?id=${product.getId()}">Удалить из корзины</a></td>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../footer.jsp" %>
</body>
</html>