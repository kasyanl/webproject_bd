
<%@ page import="kasyan.service.ProductService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ProductService productService = new ProductService();
    double totalPrise= productService.totalPrise();
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Касса</title>
</head>
<body align="center" background="${pageContext.request.contextPath}/download/xls/bg.jpg" bgcolor="#CCFFCC">
<%@include file="../header.jsp" %>
<h1>Проверьте, пожалуйста, список покупок</h1>

<h3 align="right"><a href="${pageContext.request.contextPath}/exportexcel" title="Экспортировать в excel">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/excel.png"
           width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a></h3>

<table class="table" align="center">
    <tr>
        <th width="100" align="center"><b> ID</b></th>
        <th align="center"><b> название</b></th>
        <th width="100" align="center"><b> цена, BYN</b></th>
        <th idth="100" align="center"><b> количество</b></th>
        <th width="100" align="center"><b> конечная цена, BYN</b></th>
        <th width="100" align="center"><b></b></th>


    </tr>

    <c:forEach var="product" items="${product}">
        <tr>
            <td align="center"><c:out value="${product.getId()}"/></td>
            <td align="center"><c:out value="${product.getName()}"/></td>
            <td align="center"><c:out value="${product.getActualPrice()}"/></td>
            <td align="center"><c:out value="${product.getQuantity()}"/></td>
            <td align="center"><c:out value="${product.getTotalPrice()}"/></td>
            <td><a href="${pageContext.request.contextPath}/product/deleteproductbuy?id=${product.getId()}" title="Удалить"
                   onclick="return confirm('Удалить продукт <${product.getName()}>?')"><input
                    type="image" src="${pageContext.request.contextPath}/download/xls/del.png"
                    width="18" height="18" alt="Очистить корзину"></a></td>
            </td>
        </tr>
    </c:forEach>
    <tr> </tr>
    <tr> </tr>
    <tr> </tr>
    <tr> </tr>
    <tr>
        <th align="center"><b></b></th>
        <th align="center"><b></b></th>
        <th width="100" align="center"><b></b></th>
        <th>Итого:</th>
        <th><b><%=totalPrise%></b></th>
        <th><b> BYN </b></th>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/product/checkend" title="Завершить покупку">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/save.jpg"
           width="50" height="50" alt="Экспорт в Excel файл" value="Завершить покупку"></a>
<a href="${pageContext.request.contextPath}/product/failbuyproduct" title="Отмена">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/save.jpg"
           width="50" height="50" alt="Экспорт в Excel файл" value="Отмена"></a>
<br>
<br>
<br>
<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../footer.jsp" %>
<br>
<br>
</body>
</html>