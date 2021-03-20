<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="liferaycommandclassexample.caption"/></b>
</p>

<liferay-ui:tabs names='<%= "action,render,resource" %>' type="tabs nav-tabs-default">
	<liferay-ui:section >
		<%@ include file="/action.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section >
		<%@ include file="/render.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section >
		<%@ include file="/resource.jsp" %>
	</liferay-ui:section>
</liferay-ui:tabs>