<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 10/17/2025
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List of users - V1</h1>
    <%
        String name = request.getParameter("name");
        ArrayList <String> visitors = (ArrayList<String>) application.getAttribute("visitors");

        if (visitors == null){
            visitors = new ArrayList<String>();
            application.setAttribute("visitors", visitors);
        }

        if (name != null && !name.trim().isEmpty()){
            visitors.add(name);
        }
    %>
    <h3>All visitors</h3>
    <ul>
        <% for (String visitor : visitors) { %>
            <li><%= visitor %></li>
        <% } %>
    </ul>

    <p>Add a new visitor: <code>V1.jsp?name=YourName</code></p>
</body>
</html>
