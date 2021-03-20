<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="liferaycommandclassexample.caption"/></b>
</p>

<portlet:renderURL var="renderURL">
	<portlet:param name="mvcRenderCommandName" value="/command/render_command" />
</portlet:renderURL>

<aui:button href="${renderURL}" value="Do render command request"></aui:button>