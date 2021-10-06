<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style><%@include file="/WEB-INF/view/s.css"%></style>
    <title>Main Page</title>
</head>
<body>
<h2>All employees</h2><br>

<table class="someGray">
    <tr>
        <th>N</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="emp" items="${allEmps}" varStatus="сounter">
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <!-- Click on <TR> to update employee -->
        <tr  onclick="document.location = '${updateButton}';">
            <td>
                <b>${сounter.count}</b>
            </td>
            <td>
                    ${emp.name}
            </td>
            <td>
                    ${emp.surname}
            </td>
            <td>
                    ${emp.department}
            </td>
            <td>
                    ${emp.salary}
            </td>
            <td>
                <a href="${deleteButton}">X</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            <input type="button" value="Add new" class="btn" onclick="window.location.href = '/addEmployee'"/>
        </td>
    </tr>

    <tr>
        <td colspan="6">
            <a href="api/employees">Потрогать REST (api/employees)</a>
        </td>
    </tr>
</table>


</body>
</html>
