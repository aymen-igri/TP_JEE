<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="auth" class="com.example.tp2jeejsp.Exo2.authentication" scope="session" />
<jsp:setProperty name="auth" property="username" param="username" />
<jsp:setProperty name="auth" property="password" param="password" />

<%
    boolean isAuthenticated = auth.authenticate();

    if (isAuthenticated){
        session.setAttribute("authenticatedUser", auth.getUsername());
        response.sendRedirect("succes.jsp");
    }else {
        response.sendRedirect("error.jsp");
    }
%>