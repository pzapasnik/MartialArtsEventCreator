<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sing In</title>
    <link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
    <script type="text/javascript" src="/resources/js/global.js"></script>

    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<form:form method="post" modelAttribute="fighterDetails">
    Team: <form:input path="team"/><br>
    <form:errors path="team" cssClass="error"/><br>
    Weight: <form:input path="weight"/><br>
    <form:errors path="weight" cssClass="error"/><br>
   Hight: <form:input path="hight"/><br>
    <form:errors path="hight" cssClass="error"/><br>

    Birth Year <form:input path="yearOfBirth" type="date"  /><br>
        <form:errors path="yearOfBirth" cssClass="error"/><br>

    Gender: <br/>
    MALE:<form:radiobutton path="gender" value="MALE" /><br>
    FEMALE:<form:radiobutton path="gender" value="FEMALE" />
        <form:errors path="gender" cssClass="error"/><br>

    Discipline: <form:select path="discipline" items="${disciplines}" itemLabel="label"/><br>
    <form:errors path="discipline" cssClass="error"/><br>
    <sec:csrfInput/>
    <button type="submit">Register</button>
</form:form>

</body>
</html>
