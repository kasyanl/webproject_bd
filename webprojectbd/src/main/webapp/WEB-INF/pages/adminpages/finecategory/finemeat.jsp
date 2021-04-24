<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Система учета продуктов</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg" bgcolor="#CCFFCC">
<%@include file="../../header.jsp"%>
<%@include file="../nav.jsp"%>
<h1>Продукты категории MEAT:</h1>
<table class="title" align="right">
    <tr>
        <th>
            <a href="${pageContext.request.contextPath}/product/meatdiscount" title="Изменить скидку для категории">
                <input type="image" src="https://togo.ru/images/catalogue/logo/025c2a065edeb3940dad15e0cdf9a988.png"
                       width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a>
        </th>
        <th>
            <a href="${pageContext.request.contextPath}/product/exportexcel/meat" title="Экспорт в Excel файл">
                <input type="image" src="https://macadmins.software/icons/excel.png"
                       width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a>
        </th>
    </tr>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<table class="table" align="center">
    <tr>
        <th width="100" align="center"><b> ID</b></th>
        <th><b> категория</b></th>
        <th><b> название</b></th>
        <th width="100" align="center"><b> цена</b></th>
        <th width="100" align="center"><b> скидка</b></th>
        <th width="100" align="center"><b> конечная цена</b></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${product}">
        <tr>
            <td><c:out value="${product.getId()}"/></td>
            <td><c:out value="${product.getCategory()}"/></td>
            <td><c:out value="${product.getName()}"/></td>
            <td><c:out value="${product.getPrice()}"/></td>
            <td><c:out value="${product.getDiscount()}"/></td>
            <td><c:out value="${product.getActualPrice()}"/></td>
            <td><a href="${pageContext.request.contextPath}/product/deleteproduct?id=${product.getId()}" title="Удалить"
                   onclick="return confirm('Удалить продукт <${product.getName()}> категории <${product.getCategory()}>?')"><input
                    type="image" src="https://svgsilh.com/svg/1294426.svg"
                    width="18" height="18" alt="Очистить корзину"></a></td>
            <td><a href="${pageContext.request.contextPath}/product/editproduct?id=${product.getId()}" title="Изменить"
                   onclick="return confirm('Изменить данные <${product.getName()}> категории <${product.getCategory()}>?')"><input
                    type="image" src=" https://img2.freepng.ru/20190207/ecf/kisspng-computer-icons-scalable-vector-graphics-portable-n-evaluate-svg-png-icon-free-download-353985-on-5c5cfc0bd4b6c6.5938487915495977078713.jpg"
                    width="18" height="18" alt="Очистить корзину"></a></td>
        </tr>
    </c:forEach>
    <tr>
        <th><b> ID</b></th>
        <th><b> категория</b></th>
        <th><b> название</b></th>
        <th><b> цена</b></th>
        <th><b> скидка</b></th>
        <th><b> конечная цена</b></th>
        <th></th>
        <th></th>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/selectcategorybyread">Back</a>
<br>
<br>
<%@include file="../../footer.jsp" %>
<br>
<br>
</body>
</html>