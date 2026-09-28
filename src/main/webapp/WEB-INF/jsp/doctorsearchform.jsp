<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Find Doctors Online</title>
</head>
<body>
<h2>Find Doctors Online</h2>
<form:form modelAttribute="doctor" method="post" action="${pageContext.request.contextPath}/checkDoctorsOnline">
    <table>
        <tr>
            <td>Doctor Name:</td>
            <td><form:input path="doctorName" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">(or)</td>
        </tr>
        <tr>
            <td>Registration Number:</td>
            <td><form:input path="doctorRegistrationNumber" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Check Doctors Online" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>