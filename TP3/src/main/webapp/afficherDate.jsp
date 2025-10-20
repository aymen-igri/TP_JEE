<%@ page language ="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Date</title>
    <h2>Date</h2>
    <c:set var="date" value="<%=new java.util.Date()%>"/>
    <fmt:formatDate type="time" value="${date}"/><br/>
    <fmt:formatDate type="date" value="${date}"/><br/>
</head>
<body>

</body>
</html>