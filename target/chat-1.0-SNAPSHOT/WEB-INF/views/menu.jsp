<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="header">
    <div id="logo"><a href="/home">Spring Chat</a></div>
    <br />
    <c:choose>
        <c:when test="${page == 'home'}">
                <ul id="tools">
                    <li>
                        <a href="/home">Home</a>;
                        <a href="/login">Change User</a>;
                        <a href="<c:url value="j_spring_security_logout" />" >Logout</a>
                    </li>
                </ul>
                <div id="title"><h2>You're logged in as ${user.nick}</h2></div>
        </c:when>
    </c:choose>
    <br />
</div>