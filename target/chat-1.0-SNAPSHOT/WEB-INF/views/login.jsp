<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2 id="title">Sign in to Chat or <a href="/register">register</a></h2>
<br />
<c:if test="${loginfailed}">
    <span class="loginFailed">
        Your login attempt was not successful, try again.<br />
    </span>
</c:if>

<form class="signin" action="<c:url value='j_spring_security_check' />"
     method='POST'>

<fieldset>
    <table cellspacing="0">
        <tr>
            <th><label for="username_or_email">Nick:</label></th>
            <td><input id="username_or_email"
                   name="j_username"
                   type="text" />
          </td>
        </tr>
        <tr>
            <th><label for="password">Password:</label></th>
            <td><input id="password"
                     name="j_password"
                     type="password" />
            </td>
        </tr>
        <tr>
            <th></th>
            <td><input name="commit" type="submit" value="Sign In" /></td>
        </tr>
    </table>
</fieldset>
</form>
   
   <%--<script type="text/javascript">--%>
     <%--document.getElementById('username_or_email').focus();--%>
   <%--</script>--%>
