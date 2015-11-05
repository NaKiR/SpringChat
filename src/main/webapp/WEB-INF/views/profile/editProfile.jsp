<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form method="POST" modelAttribute="user">
    <fieldset>
        <sf:errors cssClass="error" />
        <table cellspacing="0">
            <tr>
                <th><sf:label path="nick">Nick:</sf:label></th>
                <td>
                    <sf:input path="nick" size="15" maxlength="15" />
                    <small id="nick_msg"></small><br/>
                    <sf:errors path="nick" cssClass="error" />
                </td>
            </tr>

            <tr>
                <th><sf:label path="password">Password:</sf:label></th>
                <td><sf:password path="password" size="20"
                                 showPassword="true"/>
                    <small id="password_msg"></small><br/>
                    <sf:errors path="password" cssClass="error" />
                </td>
            </tr>

            <tr>
                <th><sf:label path="email">Email Address:</sf:label></th>
                <td><sf:input path="email" size="30" disabled="true"/></td>
            </tr>

            <tr>
                <th></th>
                <td><input name="commit" type="submit"
                           value="Save" /></td>
            </tr>
        </table>
    </fieldset>
</sf:form>