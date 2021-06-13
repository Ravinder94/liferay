<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<p>
	<b><liferay-ui:message key="eventproducer.caption"/></b>
</p>

<portlet:actionURL name="sendEvent" var="sendEventURL" >
</portlet:actionURL>

<aui:form  action="${sendEventURL }">
	<aui:input name="email" type="text"></aui:input>
	<aui:input name="name" type="text"></aui:input>
	<aui:button type="submit" cssClass="btn btn-primary" value="Send"></aui:button>
</aui:form>