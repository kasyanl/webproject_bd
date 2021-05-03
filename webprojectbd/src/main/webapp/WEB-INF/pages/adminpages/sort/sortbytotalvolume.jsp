<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Учет продуктов</title>
</head>
<body align="center" background="${pageContext.request.contextPath}/download/xls/bg.jpg" bgcolor="#CCFFCC">
<%@include file="../../header.jsp"%>
<%@include file="../nav.jsp"%>
<h1>Весь список продуктов</h1>
<br>
<h3>сортировка по наличию</h3>
<h3 align="right"><a href="${pageContext.request.contextPath}/exportexcel">
    <input type="image" src="https://macadmins.software/icons/excel.png"
           width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a></h3>
<br>
<table class="table" align="center">
    <tr>
        <th colspan="2" width="100" align="center"><b> ID</b></th>
        <th colspan="2" align="center"><b> категория</b></th>
        <th colspan="2" align="center"><b> название</b></th>
        <th colspan="2" width="100" align="center"><b> цена, BYN</b></th>
        <th colspan="2" width="100" align="center"><b> скидка, %</b></th>
        <th colspan="2" width="100" align="center"><b> конечная цена, BYN</b></th>
        <th colspan="2" width="100" align="center"><b> наличие, кг(шт)</b></th>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <th><a href="${pageContext.request.contextPath}/product/sortbyid"> &#x21D1; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbyidreverse">&#x21D3; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbycategory">&#x21D1; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbycategoryreverse">&#x21D3; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbyname">&#x21D1; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbynamereverse">&#x21D3;</a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbyprice">&#x21D1; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbypricereverse">&#x21D3; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbydiscount">&#x21D1; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbydiscountreverse">&#x21D3; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbyactualprice">&#x21D1; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbyactualpricereverse">&#x21D3; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbytotalvolume">&#x21D1; </a></th>
        <th><a href="${pageContext.request.contextPath}/product/sortbytotalvolumereverse">&#x21D3; </a></th>

    </tr>
    <c:forEach var="product" items="${product}">
        <tr>
            <td colspan="2" align="center"><c:out value="${product.getId()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getCategory()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getName()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getPrice()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getDiscount()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getActualPrice()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getTotalVolume()}"/></td>
            <td><a href="${pageContext.request.contextPath}/product/deleteproduct?id=${product.getId()}" title="Удалить"
                   onclick="return confirm('Удалить продукт <${product.getName()}> категории <${product.getCategory()}>?')"><input
                    type="image" src="${pageContext.request.contextPath}/download/xls/del.png"
                    width="18" height="18" alt="Очистить корзину"></a></td>
            <td><a href="${pageContext.request.contextPath}/product/editproduct?id=${product.getId()}" title="Изменить"
                   onclick="return confirm('Изменить данные <${product.getName()}> категории <${product.getCategory()}>?')"><input
                    type="image" src="${pageContext.request.contextPath}/download/xls/edit.jpg"
                    width="18" height="18" alt="Очистить корзину"></a></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="2" width="100" align="center"><b> ID</b></th>
        <th colspan="2" align="center"><b> категория</b></th>
        <th colspan="2" align="center"><b> название</b></th>
        <th colspan="2" width="100" align="center"><b> цена, BYN</b></th>
        <th colspan="2" width="100" align="center"><b> скидка, %</b></th>
        <th colspan="2" width="100" align="center"><b> конечная цена, BYN</b></th>
        <th colspan="2" width="100" align="center"><b> наличие, кг(шт)</b></th>
        <td></td>
        <td></td>
    </tr>
</table>

<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../../footer.jsp" %>
<br>
<br>
</body>
</html>