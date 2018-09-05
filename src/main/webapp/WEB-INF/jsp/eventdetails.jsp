<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${event.getName()}, Details</title>
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
<h1>${event.getName()}. Hosted by: ${event.getFederation().getName()}</h1>
<h2>${event.getDiscipline().getLabel()} - ${event.getTypeOfEvent().getLabel()}</h2>
<h3>${event.getCountry()} : ${event.getCity()} - ${event.getEventDate().getDate()}</h3>
<p>
    <a href="buy/${event.getId()}">Buy Ticket</a>
</p>
<div><c:forEach items = "${event.getFights()}" var="fight">
    <p>${fight.getCategory().getName()} :<br/>
        ${fight.getFirstFighter()}<b> VS </b> ${fight.getSecondFighter()}
    </p>
</c:forEach>
</div>

</body>
</html>
