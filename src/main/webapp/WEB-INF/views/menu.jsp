<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<a href="/">Spring Chat</a>
<c:choose>
    <c:when test="${page == 'home' || page == 'profile'}">
        <h5>You're logged in as <a href="/profile/view/${user.id}">${user.nick}</a></h5>
        <ul id="tools">
            <li>
                <a href="/">Home</a>;
            </li>
            <li>
                <a href="/profile/view/${user.id}">My profile</a>
            </li>
            <li>
                <a href="/login">Change User</a>;
            </li>
            <li>
                <a href="<c:url value="/logout" />" >Logout</a>
            </li>
        </ul>
    </c:when>
</c:choose>
<br />