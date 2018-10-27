<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
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
<p>Fighters:</p>
<c:forEach items="${usersToVerify}" var="user">
    <c:if test="${not empty user.getFighterDetails()}">
        <p>Email: ${user.getEmail()}<br>
           Team: ${user.getFighterDetails().getTeam()}<br>
           <a href="<spring:url value="/admin/user/${user.getEmail()}"/>">More Details</a>
           <a href="<spring:url value="/admin/verify/${user.getEmail()}"/>">Verify</a>
        </p>
    </c:if>
</c:forEach>

<p>Menagers:</p>
<c:forEach items="${usersToVerify}" var="user">
    <c:if test="${not empty user.getMenagerDetails()}">
        <p>Email: ${user.getEmail()}<br>
           Organization: ${user.getMenagerDetails().getOrganizationName()}<br>
            <a href="<spring:url value="/admin/user/${user.getEmail()}"/>">More Details</a>
            <a href="<spring:url value="/admin/verify/${user.getEmail()}"/>">Verify</a>
        </p>
    </c:if>
</c:forEach>
</body>
</html>
