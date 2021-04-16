<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Учет продуктов</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg" bgcolor="#CCFFCC">
<%@include file="../../header.jsp"%>
<%@include file="../nav.jsp"%>
<h1>Весь список продуктов</h1>
<br>
<h3>сортировка по котегории</h3>
<h3 align="right"><a href="${pageContext.request.contextPath}/exportexcel">Экспорт в Excel файл</a></h3>
<br>
<table class="table" align="center">
    <tr>
        <th colspan="2" width="100" align="center"><b> ID</b></th>
        <th colspan="2" align="center"><b> категории</b></th>
        <th colspan="2" align="center"><b> названию</b></th>
        <th colspan="2" width="100" align="center"><b> цене</b></th>
        <th colspan="2" width="100" align="center"><b> скидке</b></th>
        <th colspan="2"width="100" align="center"><b> конечной цене</b></th>
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

    </tr>
    <c:forEach var="product" items="${product}">
        <tr>
            <td colspan="2" align="center"><c:out value="${product.getId()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getCategory()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getName()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getPrice()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getDiscount()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getActualPrice()}"/></td>
            <td colspan="2" align="center"><a href="${pageContext.request.contextPath}/product/deleteproduct?id=${product.getId()}">Удалить</a></td>
            <td colspan="2" align="center"><a href="${pageContext.request.contextPath}/product/editproduct?id=${product.getId()}">Изменить</a></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="2" width="100" align="center"><b> ID</b></th>
        <th colspan="2" align="center"><b> категории</b></th>
        <th colspan="2" align="center"><b> названию</b></th>
        <th colspan="2" width="100" align="center"><b> цене</b></th>
        <th colspan="2" width="100" align="center"><b> скидке</b></th>
        <th colspan="2"width="100" align="center"><b> конечной цене</b></th>
        <td></td>
        <td></td>
    </tr>
</table>

<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../../footer.jsp"%>
<br>
<br>
</body>
</html>