<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="eventreceiver.caption"/></b>
</p>

<%
String userEmailAddress=ParamUtil.getString(renderRequest,"userEmailAddress",null);
	System.out.println("email : "+userEmailAddress);
%>
<h1>Email address : <%=userEmailAddress %></h1>