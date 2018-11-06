<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
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
<p>User Details:<br/>
    Email: ${user.getEmail()}<br/>
    First Name: ${user.getFirstName()}<br/>
    Last Name: ${user.getLastName()}<br/>
    Phone Number: ${user.getPhoneNumber()}<br/>
    Address: ${user.getAddress()}<br/>
    Role: ${user.getRole()}<br/>
</p>

<c:if test="${not empty user.getFighterDetails()}">
    <p>Fighter Details:<br/>
        Weight: ${details.getWeight()}<br/>
        Hight: ${details.getHight()}<br/>
        Year of Birth: ${details.getYearOfBirth()}<br/>
        Gender: ${details.getGender()}<br/>
        Discipline: ${details.getDiscipline()}<br/>
        Weight Class: ${details.getWeightClass()}<br/>
        Team: ${details.getTeam()}<br/>
        Fight Score: ${details.getAmatureFightsScore()}<br/>
    </p>
</c:if>

<c:if test="${not empty user.getMenagerDetails()}">
    <p>Menager Details:<br/>
        Organization: ${details.getOrganizationName()}<br/>
    </p>

</c:if>

<a href="<spring:url value="/admin/verify/${user.getEmail()}"/>">Verify</a>

</body>
</html>
