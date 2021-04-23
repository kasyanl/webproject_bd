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

<table class="table" align="right">
    <tr>
        <th>
            <a href="${pageContext.request.contextPath}/product/cleanbascket"
               onclick="return confirm('Вы точно хотите очистить корзину? Данные будут уберяны без возможности восстановления')">
                <input type="image" src="https://im0-tub-ru.yandex.net/i?id=5f8c305dd3c5eff594bf8166946853ee&ref=rim&n=33&w=150&h=150"
                       width="100" height="100" alt="Очистить корзину" value="Очистить корзину"></a></th>
        </th>
        <th>
            <a href="${pageContext.request.contextPath}/exportexceldel">
            <input type="image" src="https://macadmins.software/icons/excel.png"
                   width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a></th>
    </tr>
</table>
<br>
<br>
<br>
<br>
<br>
<h1>Весь список удаленных ранее продуктов</h1>
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
            <td><a href="${pageContext.request.contextPath}/product/recoveredproduct?id=${product.getId()}"
                   onclick="return confirm('Восстановить продукт <${product.getName()}> категории <${product.getCategory()}>?')">
                <input type="submit" value="Восстановить"></a></td>
            <td><a href="${pageContext.request.contextPath}/product/deleteproductbasket?id=${product.getId()}"
                   onclick="return confirm('Вы уверены? Продукт <${product.getName()}> категории <${product.getCategory()}> будет удален без возможности восстановления!')">
                <input type="submit" value="Удалить из корзины"></a></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../footer.jsp" %>
</body>
</html>