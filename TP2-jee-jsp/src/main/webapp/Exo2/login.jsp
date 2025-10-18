<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login page</h1>
<form action="authenticate.jsp" method="post">
    <div class="form-group">
        <label for="username">Username</label>
        <input
                type="text"
                id="username"
                name="username"
                placeholder="Enter your username"
                required
                autofocus
        />
    </div>

    <div class="form-group">
        <label for="password">Password</label>
        <input
                type="password"
                id="password"
                name="password"
                placeholder="Enter your password"
                required
        />
    </div>

    <button type="submit" class="btn-login">
        Connect →
    </button>
</form>
</body>
</html>
