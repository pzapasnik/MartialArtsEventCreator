<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Event</title>
    <link rel="stylesheet" href="https://unpkg.com/@coreui/coreui/dist/css/coreui.min.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/@coreui/coreui/dist/js/coreui.min.js"></script>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="event">

    Event Name: <form:input path="name"/><br/>
    <form:errors path="name"
                 cssClass="error" /><br/>

    Country: <form:input path="country"/><br/>
    <form:errors path="country"
                 cssClass="error" /><br/>

    City: <form:input path="city"/><br>
    <form:errors path="city"
                 cssClass="error" /><br/>

    Address: <form:input path="address"/><br>
    <form:errors path="address"
                 cssClass="error" /><br/>

    Event Date: <form:input type="datetime-local"  path="eventDate" title="dd/MM/yyyy, HH:mm:ss"/>
    <form:errors path="eventDate"
                 cssClass="error" /><br/>

    Type Of Event: <form:select path="discipline" items="${disciplines}" itemLabel="label"/>
    <form:errors path="discipline"
                 cssClass="error" /><br/>

    Type Of Event: <form:select path="typeOfEvent" items="${typesOfEvent}" itemLabel="label"/>
    <form:errors path="typeOfEvent"
                 cssClass="error" /><br/>

    Number of Tickets: <form:input path="numberOfTickets"/><br>
    <form:errors path="numberOfTickets"
                 cssClass="error" /><br/>

    <input type="submit" value="save">
</form:form>
</body>
</html>
