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
    <script src=""
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/global.js"></script>

    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<c:url value="/login" var="loginVar"/>
<form method="POST" action="${loginVar}" >
    E-mail: <input path="email"/><br/>

    Password:<input path="password"/><br/>

    <sec:csrfInput/>

    <c:if test="${param.error != null}">
        <p class="error">Invalid Email or Password</p>
    </c:if>

    <c:if test="${param.logout != null}">
        <p>You have succsessfully been logout</p>
    </c:if>

    <input type="submit" value="Login">
</form>
</body>
</html>
