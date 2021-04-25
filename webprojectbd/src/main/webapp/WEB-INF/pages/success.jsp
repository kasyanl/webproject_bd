<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body align="center" background="${pageContext.request.contextPath}/download/xls/bg.jpg" bgcolor="#CCFFCC">
<%@include file="header.jsp"%>
<h1><%= request.getAttribute("message") %></h1>
<a href="${pageContext.request.contextPath}/content" target="content">Home</a>
<%@include file="footer.jsp"%>
</body>
</html>