<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового продукта</title>
</head>
<body align="center" background="http://sensitiv-eysk.ru/wp-content/uploads/2017/06/opera-background-light-blue.jpg"
      bgcolor="#CCFFCC">
<%@include file="../header.jsp" %>
<%@include file="nav.jsp" %>
<h2>Добавление продукта:</h2>

<form  action="${pageContext.request.contextPath}/product/addproduct" method="post">

    категория<br><label>
    <select name="category">
        <option value="FRUITS">FRUITS</option>
        <option value="BERRIES">BERRIES</option>
        <option value="VEGETABLES">VEGETABLES</option>
        <option value="MILK_PRODUCT">MILK_PRODUCT</option>
        <option value="MEAT">MEAT</option>
        <option value="ALCOHOLIC_BEVERAGES">ALCOHOLIC_BEVERAGES</option>
    </select>
</label><br>
    <label><input name="name" placeholder="Название" type="text"></label><br/>
    <label><input name="price" placeholder="цена, BYN" type="text"></label> <br/>
    <label><input name="discount" placeholder="Скидка, %" type="text"></label> <br/>
    <br> <input type="image" src="https://localmarketing.university/wp-content/uploads/2016/09/save-file_z1uSqULO_L.jpg"
                width="50" height="50" alt="Добавить новый продукт" value="Сохранить">
    <br><b>Сохранить</b>
</form>
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