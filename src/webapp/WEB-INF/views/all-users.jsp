<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All users</h2>
<br>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>LastName</th>
        <th>Age</th>
        <th>Password</th>
        <th>Role</th>
        <th>Operations</th>

        <c:forEach var="us" items="${allUsers}">
        <c:url var="updateButton" value="/admin/updateinfo">
            <c:param name="usId" value="${us.id}"/>

        </c:url>

        <c:url var="deleteButton" value="/admin/deleteUser">
            <c:param name="usId" value="${us.id}"/>
        </c:url>
    <tr>
        <td>${us.id}</td>
        <td>${us.name}</td>
        <td>${us.lastName}</td>
        <td>${us.age}</td>
        <td>${us.password}</td>
        <td>${us.roles}</td>

        <td>
            <input type="button" value="Update"
                   onclick="window.location.href = '${updateButton}'"/>
            <input type="button" value="Delete"
                   onclick="window.location.href = '${deleteButton}'"/>
        </td>


        </c:forEach>
    </tr>
</table>

<br>

<c:url var="addButton" value="/admin/addNewUser">

</c:url>

<input type="button" value="Add"
       onclick="window.location.href = '${addButton}'"/>

<br>
<input type="button" value="logout"
       onclick="window.location.href = '/login'"/>


</body>
</html>