<%@ page import="kasyan.bean.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение данных.</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg" bgcolor="#CCFFCC">
<%@include file="../header.jsp"%>
<%@include file="nav.jsp"%>
<h2>Замените необходимые данные:</h2>
<% Product product = (Product) request.getAttribute("product"); %>
<form action="${pageContext.request.contextPath}/product/editproduct?id=<%=product.getId()%>" method="post">
    <label>
        категория<select <%=product.getCategory()%> name="category">
            <option value="<%=product.getCategory()%>"><%=product.getCategory()%></option>
            <option value="FRUITS">FRUITS</option>
            <option value="BERRIES">BERRIES</option>
            <option value="VEGETABLES">VEGETABLES</option>
            <option value="MILK_PRODUCT">MILK_PRODUCT</option>
            <option value="MEAT">MEAT</option>
            <option value="ALCOHOLIC_BEVERAGES">ALCOHOLIC_BEVERAGES</option>
        </select>
    </label><br/>
    название продукта<label><input name="name" placeholder="название" type="text" value="<%=product.getName()%>"></label> <br/>
    стоимость подукта, BYN<label><input name="price" placeholder="цена" type="text" value="<%=product.getPrice()%>"></label> <br/>
    скидкапродукта, %<label><input name="discount" placeholder="скидка" type="text" value="<%=product.getDiscount()%>"></label> <br/>
    <input type="submit" value="Сохранить изменения">
</form>
<a href="${pageContext.request.contextPath}/content">Home</a>
<br>
<br>
<%@include file="../footer.jsp"%>
<br>
<br>
</html>