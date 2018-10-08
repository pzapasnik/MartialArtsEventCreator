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
    <form:form method="post" modelAttribute="user">
    Email: <form:input path="email" /><br>
        <form:errors path="email" cssClass="error"/><br>
    Password: <form:password path="password" /><br>
        <form:errors path="password" cssClass="error"/><br>
    First Name: <form:input path="firstName"/><br>
        <form:errors path="firstName" cssClass="error"/><br>
    Last Name: <form:input path="lastName"/><br>
        <form:errors path="lastName" cssClass="error"/><br>
    Phone Number: <form:input path="phoneNumber"/><br>
        <form:errors path="phoneNumber" cssClass="error"/><br>
    Address: <form:input path="address"/><br>
        <form:errors path="address" cssClass="error"/><br>

        <select name="account">
            <option value="user">as User</option>
            <option value="fighter">as Fighter</option>
            <option value="menager">as a Federation Menager</option>
        </select>
            

        <sec:csrfInput/>
        <button type="submit">Register</button>
    </form:form>
</body>
</html>
