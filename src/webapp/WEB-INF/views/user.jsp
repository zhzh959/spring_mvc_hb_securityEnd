<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>User</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>LastName</th>
        <th>Age</th>
        <th>Password</th>
        <th>Role</th>

        <br>

    <tr>
        <td>${user.name}</td>
        <td>${user.lastName}</td>
        <td>${user.age}</td>
        <td>${user.password}</td>
        <td>${user.roles}</td>
    </tr>
</table>

<br>

<input type="button" value="logout"
       onclick="window.location.href = '/login'"/>


</body>
</html>