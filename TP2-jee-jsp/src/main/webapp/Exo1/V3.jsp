<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 10/17/2025
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List of users - V3</h1>
<c:if test="${empty applicationScope.visitorsListEL}" >
    <c:set var="visitorsListEL" scope="application" value="<%= new java.util.ArrayList<String>() %>" />
</c:if>

<c:if test="${not empty param.name}">
    <%
        java.util.List<String> list = (java.util.List<String>) application.getAttribute("visitorsListEL");

        if (list == null){
            list = new java.util.ArrayList<String>();
            application.setAttribute("visitorsListEL", list);
        }

        String name = request.getParameter("name");
        if (name != null && !name.trim().isEmpty()){
            list.add(name);
        }
    %>
</c:if>
<c:choose>
    <c:when test="${empty applicationScope.visitorsListEL}">
        <h3>No visitors yet.</h3>
    </c:when>
    <c:otherwise>
        <h3>All visitors</h3>
        <ul>
            <c:forEach var="visitor" items="${applicationScope.visitorsListEL}">
                <li>${visitor}</li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>
</body>
</html>
