<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="liferaycommandclassexample.caption"/></b>
</p>
<portlet:actionURL name="/commands/action_command" var="actionURL" />


<aui:button href="${actionURL}" value="Do action command request"></aui:button>