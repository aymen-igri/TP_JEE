<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forward Example</title>
</head>
<body>

<%
    System.out.println("Before forward: HTML code is being generated");
%>

<p>This HTML is before the forward.</p>

<jsp:forward page="ForwardTarget.jsp" />

<%
    System.out.println("After forward");
%>

<p>after the forward.</p>

</body>
</html>
