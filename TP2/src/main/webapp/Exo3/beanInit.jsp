<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 10/18/2025
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.time.*" %>

<html>
<head>
    <title>Agence</title>
</head>
<body>
<h2>Remplissez les informations de l'agence :</h2>

<form action="beanInit.jsp" method="post">
    Nom: <input type="text" name="name" /><br/>
    Ville: <input type="text" name="ville" /><br/>
    Code Postal: <input type="text" name="codepostal" /><br/>
    <input type="submit" value="Envoyer" />
</form>

<jsp:useBean id="agence" class="com.example.tpp2.Bean.Agence" scope="session" />
<jsp:setProperty name="agence" property="*" />
<jsp:setProperty name="agence" property="*"/>
<jsp:setProperty name="agence" property ="*"/>
<p>Nom: <jsp:getProperty name="agence" property="name" /></p>
<p>Ville: <jsp:getProperty name="agence" property="ville" /></p>
<p>Code Postal: <jsp:getProperty name="agence" property="codepostal" /></p>
<p>

    <a href="beanShow.jsp">Voir les informations de l'agence</a>
</p>

</body>
</html>