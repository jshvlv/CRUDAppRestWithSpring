<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/WEB-INF/view/s.css"%></style>
    <title>Please add new Employee</title>
</head>
<body>
<h2>Employee INFO</h2>

<form:form action="/saveEmployee" modelAttribute="employee">

    <form:hidden path="id"/>
    <table class="someGray">
        <tr><td> Name </td>
            <td><form:input path="name" cssClass="txt"/></td>
        </tr>

        <tr>
        <td>Surname </td>
        <td><form:input path="surname" cssClass="txt"/></td>
        </tr>

        <tr>
            <td>Department </td>
            <td><form:input path="department" cssClass="txt"/></td>
        </tr>

        <tr>
            <td>Salary</td>
            <td><form:input path="salary" cssClass="txt"/></td>
        </tr>

        <tr>
            <td colspan="2">
    <input type="submit" value="Save" class="btn">
            </td>
        </tr>
    </table>

</form:form>

</body>
</html>
