<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String authenticatedUser = (String) session.getAttribute("authenticatedUser");
    if (authenticatedUser == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Welcome <%=authenticatedUser %></h1>
</body>
</html>
