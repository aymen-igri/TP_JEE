<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List of users - V2</h1>
<jsp:useBean id="visitorManager" class="com.example.tp2jeejsp.Exo1.Visitor" scope="application" />
<jsp:setProperty name="visitorManager" property="name" param="name" />

<%
    String visitorName = request.getParameter("name");
    if (visitorName != null && !visitorName.trim().isEmpty()) {
        visitorManager.addVisitor(visitorName);
    }
%>

<%if (visitorManager.isEmpty()) {%>
    <h3>No visitors yet.</h3>
<%} else { %>
    <h3>All visitors</h3>
    <ul>
        <%for (String visitor : visitorManager.getAllVisitors()) { %>
            <li><%= visitor %></li>
        <% } %>
    </ul>
<%} %>
</body>
</html>
