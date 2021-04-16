<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<nav>
    <ul>
        <a href="${pageContext.request.contextPath}/content" target="content">Главная</a> |
        <a href="${pageContext.request.contextPath}/product/allproduct" target="content">Список всех продуктов</a> |
       <a href="${pageContext.request.contextPath}/selectcategorybyread" target="content">Получить список одной категории</a> |
        <a href="${pageContext.request.contextPath}/product/addproduct" target="content">Добавить новый продукт</a>
        <a href="${pageContext.request.contextPath}/">На стартовую страницу</a>
    </ul>
</nav>
</body>
</html>
