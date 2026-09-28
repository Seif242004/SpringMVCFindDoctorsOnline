<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Details</title>
</head>
<body>
<h2>Doctor Details</h2>
<c:if test="${not empty ErrorMessage}">
    <p><c:out value="${ErrorMessage}" /></p>
</c:if>
<c:if test="${empty ErrorMessage}">
<p><b>Name:</b> <c:out value="${DoctorName}" /></p>
<p><b>Registration Number:</b> <c:out value="${RegistrationNumber}" /></p>
<p><b>Qualification:</b> <c:out value="${Qualification}" /></p>
<p><b>Gender:</b> <c:out value="${Gender}" /></p>
</c:if>
<p><a href="${pageContext.request.contextPath}/doctorsearchform">Search again</a></p>
</body>
</html>
