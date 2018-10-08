<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a href="<spring:url value="/"/>"   class="navbar-brand">MartialArts Event Creator</a>
        </div>

        <ul class="nav navbar-nav">
            <li><a href="<spring:url value="/menagerDetails"/>">Federations</a></li>
            <li><a href="<spring:url value="/events"/>">Events</a></li>
            <li><a href="<spring:url value="/fighters"/>">Fighters</a></li>

            <sec:authorize access="isAuthenticated()" var="authenticated"/>
            <c:choose>
                <c:when test="${authenticated}">
                    <li>
                        <a id="logout" href="#">Logout</a>
                        <form id="logout-form" action="<c:url value="/logout"/>" method="post">
                            <sec:csrfInput/>
                        </form>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a href="<spring:url value="/login"/>">Sing In</a></li>
                    <li><a href="<spring:url value="/register"/>">Sing Up</a></li>
                </c:otherwise>
            </c:choose>

        </ul>
    </div>
</nav>
