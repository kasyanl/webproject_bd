<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Some error...</title>
</head>
<body align="center" background="${pageContext.request.contextPath}/download/xls/bg.jpg" bgcolor="#CCFFCC">
<%@include file="header.jsp"%>
<h1><%=request.getAttribute("error")%></h1>
<a href="${pageContext.request.contextPath}/content">Home</a>
<%@include file="footer.jsp"%>
</body>
</html>