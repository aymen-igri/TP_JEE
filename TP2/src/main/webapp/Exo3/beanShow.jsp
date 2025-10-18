<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.example.tp2jeejsp.Exo3.Agence" %>

<html>
<head>
    <title>Afficher Bean Agence</title>
</head>
<body>

<h2>Informations de l'agence :</h2>

<jsp:useBean id="agence" class="com.example.tp2jeejsp.Exo3.Agence" scope="session" />

<p>Nom: <jsp:getProperty name="agence" property="name" /></p>
<p>Ville: <jsp:getProperty name="agence" property="ville" /></p>
<p>Code Postal: <jsp:getProperty name="agence" property="codepostal" /></p>

</body>
</html>
