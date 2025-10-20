<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>ShowUsers</title>
</head>
<body>
<sql:setDataSource var ="db"
                   driver="org.postgresql.Driver"
                   url="jdbc:postgresql://ep-noisy-leaf-ad6e0rw8-pooler.c-2.us-east-1.aws.neon.tech/neondb?sslmode=require"
                   user="neondb_owner"
                   password="npg_hTfyMz0D6Jnd"/>
<sql:query var ="users" dataSource="${db}">
    SELECT * FROM users;
</sql:query>
<c:choose>
    <c:when test="${users.rowCount>0}">
        <table >
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Email</th>
            </tr>
            <c:forEach var="user" items="${users.rows}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.nom}" /></td>
                    <td><c:out value="${user.email}" /></td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>Aucun utilisateur trouvé dans la base de données.</p>
    </c:otherwise>
</c:choose>
</body>
</html>
