<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>User info</h2>
<br>

<form:form action="saveUser" modelAttribute="user" method="post">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br>
    LastName <form:input path="lastName"/>
    <br>
    Age <form:input path="age"/>
    <br>
    Password <form:input path="password"/>
    <br>

    <fieldset>
        <ul>
            <legend>Role</legend>
            <c:forEach var="role" items="${rolelist}">
                <li>
                    <form:checkbox path="roles" value="${role.getName()}"/>
                        ${role}
                </li>
            </c:forEach>
        </ul>
        <br/>
    </fieldset>

    <input type="submit" value="OK">

</form:form>
</body>
</html>
