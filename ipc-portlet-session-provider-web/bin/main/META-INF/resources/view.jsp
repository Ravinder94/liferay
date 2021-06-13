<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="ipcportletsessionproviderweb.caption"/></b>
</p>

<portlet:actionURL var="senddataURL" name="sendData">
</portlet:actionURL>

<aui:form action="${senddataURL }">
	<aui:input type="text" name="name"/>
	<aui:input type="text" name="email"/>
	<aui:input type="text" name="mobilenum"/>
	
	<aui:button type="submit" value="Send data" />
</aui:form>