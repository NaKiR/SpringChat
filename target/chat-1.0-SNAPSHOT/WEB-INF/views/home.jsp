<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="chat">
    ${chatHistory}
</div>
<br />
<sf:form id="chatMessageSubmitForm" >
    <textarea id="chatMessage" name="chatMessage" rows="1" cols="50"></textarea>
    <br />
    <input type="button" name="postMessage" id="postMessage" value="Post Message">
</sf:form>
